package com.frightanic.smn;

import com.frightanic.smn.core.GeoAdmin;
import com.frightanic.smn.health.SmnHealthCheck;
import com.frightanic.smn.resource.RootResource;
import com.frightanic.smn.resource.SmnResource;
import io.federecio.dropwizard.swagger.SwaggerDropwizard;
import com.googlecode.webutilities.filters.ResponseCacheFilter;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import io.federecio.dropwizard.swagger.SwaggerHostResolver;
import org.apache.commons.lang.StringUtils;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.io.IOException;
import java.util.EnumSet;

public class OpenDataSmn extends Application<OpenDataSmnConfiguration> {
  private final Logger logger = LoggerFactory.getLogger(OpenDataSmn.class);
  private final SwaggerDropwizard swaggerDropwizard = new SwaggerDropwizard();

  public static void main(String[] args) throws Exception {
    new OpenDataSmn().run(args);
  }

  @Override
  public String getName() {
    return "open-data-smn";
  }

  @Override
  public void initialize(Bootstrap<OpenDataSmnConfiguration> bootstrap) {
    bootstrap.addBundle(new AssetsBundle());
    bootstrap.addBundle(new ViewBundle());
    swaggerDropwizard.onInitialize(bootstrap);
  }

  @Override
  public void run(OpenDataSmnConfiguration configuration, Environment environment) {
    configureSwagger(configuration, environment);
    registerCrossOriginFilter(environment);
    environment.jersey().register(new RootResource());
    configureSmn(configuration, environment);
  }

  private void configureSwagger(OpenDataSmnConfiguration configuration, Environment environment) {
    try {
      String swaggerPort = configuration.getSwaggerPort();
      if (StringUtils.isEmpty(swaggerPort)) {
        swaggerDropwizard.onRun(configuration, environment);
      } else {
        swaggerDropwizard.onRun(configuration, environment, SwaggerHostResolver.getSwaggerHost(),
          Integer.parseInt(swaggerPort));
      }
    } catch (IOException e) {
      logger.error("Failed to initialize Swagger Dropwizard.", e);
    }
  }

  private void configureSmn(OpenDataSmnConfiguration configuration, Environment environment) {
    GeoAdmin geoAdmin = new GeoAdmin(configuration);
    SmnResource smnResource = new SmnResource(geoAdmin);
    SmnHealthCheck healthCheck = new SmnHealthCheck(geoAdmin);
    environment.healthChecks().register("smn", healthCheck);
    environment.jersey().register(smnResource);
    registerSmnCachingFilter(configuration, environment);
  }

  private void registerSmnCachingFilter(OpenDataSmnConfiguration configuration, Environment environment) {
    FilterRegistration.Dynamic responseCacheFilter = environment.servlets().addFilter("responseCacheFilter",
      new ResponseCacheFilter());
    responseCacheFilter.setInitParameter("reloadTime", String.valueOf(
      configuration.getResponseCacheTimeToLiveMinutes() * 60));
    responseCacheFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/smn/*");
  }

  private void registerCrossOriginFilter(Environment environment) {
    FilterRegistration.Dynamic crossOriginFilter = environment.servlets().addFilter("crossOriginFilter",
      new CrossOriginFilter());
    crossOriginFilter.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/smn/*");
  }
}
