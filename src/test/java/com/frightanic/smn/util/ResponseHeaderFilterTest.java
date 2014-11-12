package com.frightanic.smn.util;

import org.junit.Test;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Tests ResponseHeaderFilter.
 */
public class ResponseHeaderFilterTest {
  private final ResponseHeaderFilter filter = new ResponseHeaderFilter();
  private final FilterChain filterChain = mock(FilterChain.class);
  private final HttpServletRequest servletRequest = mock(HttpServletRequest.class);
  private final HttpServletResponse servletResponse = mock(HttpServletResponse.class);

  /**
   * See method name.
   */
  @Test
  public void shouldSetVaryAcceptHeaderIfBlank() throws IOException, ServletException {
    // given
    // when
    filter.doFilter(servletRequest, servletResponse, filterChain);
    // then
    verify(servletResponse).addHeader("Vary", "Accept");
  }

  /**
   * See method name.
   */
  @Test
  public void shouldAppendVaryAcceptHeaderIfAlreadySet() throws IOException, ServletException {
    // given
    given(servletResponse.getHeader("Vary")).willReturn("Accept-Encoding");
    // when
    filter.doFilter(servletRequest, servletResponse, filterChain);
    // then
    verify(servletResponse).addHeader("Vary", "Accept-Encoding,Accept");
  }
}