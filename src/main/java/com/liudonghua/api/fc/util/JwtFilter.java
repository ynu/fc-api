package com.liudonghua.api.fc.util;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import com.liudonghua.api.fc.Constants;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

@Component
public class JwtFilter extends GenericFilterBean {

    @Override
    public void doFilter(final ServletRequest req,
                         final ServletResponse res,
                         final FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse)res;
        String token = request.getParameter(Constants.JWT_DEFAULT_TOKEN_NAME);
        // 如果没有Request parameter Token
        if(token == null) {
        	// 检查Header里面的Authorization header
            String authHeader = request.getHeader("Authorization");
            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                token = authHeader.substring(7);
            }
            if(token == null) {
            	Utils.tokenInvalidateResponse(response);
            	return;
            }
        }

        try {
            final Claims claims = Jwts.parser().setSigningKey(Constants.JWT_DEFAULT_SECRET)
                .parseClaimsJws(token).getBody();
            request.setAttribute("claims", claims);
        }
        catch (Exception e) {
			e.printStackTrace();
			Utils.tokenInvalidateResponse(response);
        }

        chain.doFilter(req, res);
    }


}
