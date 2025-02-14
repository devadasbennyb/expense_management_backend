package com.tecnics.expenseservices.config;

import java.io.IOException;
import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * @author Mohammad Faizullah Ansari
 * @email faizullah_md@tecnics.com
 * @description
 */

@Component
public class JwtAuthenticationEntryPoint
  implements AuthenticationEntryPoint, Serializable {

  private static final Logger log = LoggerFactory.getLogger(
    JwtAuthenticationEntryPoint.class
  );

  private static final long serialVersionUID = -7858869558953243875L;

  @Override
  public void commence(
    HttpServletRequest request,
    HttpServletResponse response,
    AuthenticationException authException
  )
    throws IOException {
    log.info("<<< JwtAuthenticationEntryPoint >>>");

    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
  }
}
