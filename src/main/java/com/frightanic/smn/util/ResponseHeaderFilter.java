package com.frightanic.smn.util;

import com.google.common.base.Joiner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Adds 'Accept' to the 'Vary' HTTP header.
 */
public final class ResponseHeaderFilter implements Filter {
  private final Logger logger = LoggerFactory.getLogger(ResponseHeaderFilter.class);
  private final Joiner HEADER_JOINER = Joiner.on(",").skipNulls();

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    logger.info("Filter initialized.");
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
    ServletException {
    chain.doFilter(request, response);
    HttpServletResponse httpServletResponse = (HttpServletResponse) response;
    httpServletResponse.addHeader("Vary", HEADER_JOINER.join(httpServletResponse.getHeader("Vary"), "Accept"));
    logger.trace("Added 'Accept' to 'Vary' HTTP header.");
  }

  @Override
  public void destroy() {
    logger.info("Filter destroyed.");
  }
}
