package com.example.SpringSecEx.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import org.springframework.stereotype.Component;


import com.example.SpringSecEx.service.JWTservice;


@Component
public class JwtFilter extends OncePerRequestFilter {
    // This class will be used to implement JWT authentication filter logic
    // For now, it is just a placeholder and does not contain any logic.

    @Autowired
    private JWTservice jwtService;

    @Autowired
    ApplicationContext applicationContext;

    
    @Override
    protected void doFilterInternal(javax.servlet.http.HttpServletRequest request,
                                    javax.servlet.http.HttpServletResponse response,
                                    javax.servlet.FilterChain filterChain) throws javax.servlet.ServletException, java.io.IOException {
        
        String authorizationHeader = request.getHeader("Authorization");
        String token = null;
        String username = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.substring(7);
            username = jwtService.extractUsername(token);
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            // Here you would typically load the user details and set the authentication in the security context
            // For now, we are just printing the username to the console

            UserDetails userDetails = this.applicationContext.getBean(UserDetailsService.class).loadUserByUsername(username);

           if(jwtService.validateToken(token, userDetails)) {
               UsernamePasswordAuthenticationToken autoToken = 
                   new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                autoToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(autoToken);


            } else {
                System.out.println("Invalid token for user: " + username);
            }
        }

        filterChain.doFilter(request, response);

    }

}