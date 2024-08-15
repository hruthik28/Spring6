package com.example.SpringSecurity.CSRF.config;

import com.example.SpringSecurity.CSRF.service.MyUserDetailsService;
import com.example.SpringSecurity.PasswordEncoder.service.JWTService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JWTFilter extends OncePerRequestFilter {

    @Autowired
    private JWTService jwtService;

    @Autowired
    ApplicationContext context;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtYWFzbWRuIiwiaWF0IjoxNzIzNzA1NjYzLCJleHAiOjE3MjM3MDU2OTl9.nqGSR-w4cA84Y06-4xfKcdtNshbJKkB_pMVg5aVGRas
        String authHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;

        if(null != authHeader && authHeader.startsWith("Bearer ")){
            token = authHeader.substring(7); //to remove Bearer from header and then use only token
            username = jwtService.extractUserName(token);
        }

        // if SecurityContextHolder.getContext().getAuthentication() is not null then the request is already authenticated
        if(null != username && null == SecurityContextHolder.getContext().getAuthentication()){

            UserDetails userDetails = context.getBean(MyUserDetailsService.class).loadUserByUsername(username);
            // this will fire database and get the userdetails based on username

            if(jwtService.validateToken(token, userDetails)){
                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
                // this code will say that no need to pass username and password instead get it authenticated with authToken and then pass it to next request
            }
        }
        filterChain.doFilter(request, response);
    }
}
