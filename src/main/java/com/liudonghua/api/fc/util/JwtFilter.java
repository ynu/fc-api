package com.liudonghua.api.fc.util;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.GenericFilterBean;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtFilter extends GenericFilterBean {

    @Autowired
    Environment environment;

    @Override
    public void doFilter(final ServletRequest req, final ServletResponse res, final FilterChain chain)
            throws IOException, ServletException {

        // https://stackoverflow.com/questions/32494398/unable-to-autowire-the-service-inside-my-authentication-filter-in-spring/32495593
        // SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
        if (environment == null) {
            ServletContext servletContext = req.getServletContext();
            WebApplicationContext webApplicationContext = WebApplicationContextUtils
                    .getWebApplicationContext(servletContext);
            environment = webApplicationContext.getBean(Environment.class);
        }

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String token = request.getParameter(System.getenv().get("JWT_DEFAULT_TOKEN_NAME"));
        // 如果没有Request parameter Token
        if (token == null) {
            // 检查Header里面的Authorization header
            String authHeader = request.getHeader("Authorization");
            if (!StringUtils.isEmpty(authHeader)) {
                token = authHeader;
            }
            if (token == null) {
                Utils.tokenInvalidateResponse(response);
                return;
            }
        }
        try {
            final Claims claims = Jwts.parser().setSigningKey(System.getenv().get("JWT_DEFAULT_SECRET"))
                    .parseClaimsJws(token).getBody();
            request.setAttribute("claims", claims);
        } catch (Exception e) {
            e.printStackTrace();
            Utils.tokenInvalidateResponse(response);
            return;
        }
        chain.doFilter(req, res);
    }

}
