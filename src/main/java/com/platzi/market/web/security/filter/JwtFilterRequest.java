package com.platzi.market.web.security.filter;

import com.platzi.market.domain.service.PlatziUserDetailsService;
import com.platzi.market.web.security.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilterRequest extends OncePerRequestFilter {

    private JWTUtil jwtUtil;
    private  PlatziUserDetailsService service;

    @Autowired
    public JwtFilterRequest(JWTUtil jwtUtil, PlatziUserDetailsService service) {
        this.jwtUtil = jwtUtil;
        this.service = service;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authorizationHeader = request.getHeader("Authorization");

        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer")) {
            //obtener el cuerpo del jwt
            String jwt = authorizationHeader.substring(7);
            String username = jwtUtil.extractUsername(jwt);

            //verificar que aun no exista ninguna autentificacion para este usuario
            if(username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                //verificar si el usuario existe dentro del sistema de authentication
                UserDetails userDetails = service.loadUserByUsername(username);

                //verificar que el jwt sea correcto
                if(jwtUtil.validateToken(jwt, userDetails)) {
                    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }
        }

        filterChain.doFilter(request, response);
    }
}
