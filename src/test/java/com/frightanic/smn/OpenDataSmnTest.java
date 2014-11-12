package com.frightanic.smn;

import com.codahale.metrics.health.HealthCheckRegistry;
import com.frightanic.smn.health.SmnHealthCheck;
import com.frightanic.smn.resource.RootResource;
import com.frightanic.smn.resource.SmnResource;
import com.frightanic.smn.util.ResponseCacheFilter;
import com.frightanic.smn.util.ResponseHeaderFilter;
import io.dropwizard.jersey.setup.JerseyEnvironment;
import io.dropwizard.jetty.setup.ServletEnvironment;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServlet;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Tests the main class OpenDataSmn.
 */
public class OpenDataSmnTest {
  private final OpenDataSmn openDataSmn = new OpenDataSmn();
  private final OpenDataSmnConfiguration configuration = new OpenDataSmnConfiguration();

  private final Environment environment = mock(Environment.class);
  private final JerseyEnvironment jerseyEnvironment = mock(JerseyEnvironment.class);
  private final ServletEnvironment servletEnvironment = mock(ServletEnvironment.class);
  private final HealthCheckRegistry healthCheckRegistry = mock(HealthCheckRegistry.class);

  /**
   * Setup.
   */
  @Before
  public void setup() {
    configuration.setDataUrl("http://foo.bar");
    configuration.setDataCacheTimeToLiveMinutes("5");
    configuration.setResponseCacheTimeToLiveMinutes("1");

    when(servletEnvironment.addServlet(anyString(), any(HttpServlet.class))).thenReturn(mock(ServletRegistration
      .Dynamic.class));
    when(servletEnvironment.addFilter(anyString(), any(Filter.class))).thenReturn(mock(FilterRegistration.Dynamic
      .class));

    when(jerseyEnvironment.getUrlPattern()).thenReturn("/foo");

    when(environment.healthChecks()).thenReturn(healthCheckRegistry);
    when(environment.servlets()).thenReturn(servletEnvironment);
    when(environment.jersey()).thenReturn(jerseyEnvironment);
  }

  /**
   * See method name.
   */
  @Test
  public void shouldRegisterResourcesOnce() {
    // given
    // when
    openDataSmn.run(configuration, environment);
    // then
    verify(jerseyEnvironment).register(isA(RootResource.class));
    verify(jerseyEnvironment).register(isA(SmnResource.class));
  }

  /**
   * See method name.
   */
  @Test
  public void shouldRegisterSmnHealthCheck() {
    // given
    // when
    openDataSmn.run(configuration, environment);
    // then
    verify(healthCheckRegistry).register(eq("smn"), isA(SmnHealthCheck.class));
  }

  /**
   * See method name.
   */
  @Test
  public void shouldRegisterThreeFiltersInOrder() {
    // given
    InOrder inOrder = inOrder(servletEnvironment);
    // when
    openDataSmn.run(configuration, environment);
    // then
    inOrder.verify(servletEnvironment).addFilter(eq("crossOriginFilter"), isA(CrossOriginFilter.class));
    inOrder.verify(servletEnvironment).addFilter(eq("responseCacheFilter"), isA(ResponseCacheFilter.class));
    inOrder.verify(servletEnvironment).addFilter(eq("responseHeaderFilter"), isA(ResponseHeaderFilter.class));
  }
}