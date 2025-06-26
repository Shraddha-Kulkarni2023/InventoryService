package com.example.InventoryService.Filter;

import com.example.InventoryService.Service.JwtValidator;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collections;

@Component
public class JwtAuthenticationFilter extends GenericFilter {

    private final JwtValidator jwtValidator;

    public JwtAuthenticationFilter(JwtValidator jwtValidator) {

        this.jwtValidator = jwtValidator;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {


        HttpServletRequest http = (HttpServletRequest) request;

        String authHeader = http.getHeader("Authorization");

        if(authHeader != null && authHeader.startsWith("Bearer ")) {

            String token = authHeader.substring(7);

            if(jwtValidator.validateToken(token)) {

                String username = jwtValidator.getUsername(token);
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username,null, Collections.emptyList());
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }

        chain.doFilter(request,response);

    }


}

