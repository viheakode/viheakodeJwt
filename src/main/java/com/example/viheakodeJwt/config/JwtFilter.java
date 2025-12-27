package com.example.viheakodeJwt.config;

import com.example.viheakodeJwt.model.User;
import com.example.viheakodeJwt.repository.UserRepo;
import com.example.viheakodeJwt.service.MoyJwtService;
import com.example.viheakodeJwt.service.MyUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    protected MoyJwtService moyJwtService;

    @Autowired
    ApplicationContext context;

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Autowired
    private UserRepo userRepo;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String apiToken = request.getHeader("apiToken");
        String token = null;
        String username = null;

        if (apiToken != null && apiToken.startsWith("viheakode ")){
            token = apiToken.substring(10);
            username = moyJwtService.extractUsername(token);
        }
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = context.getBean(MyUserDetailsService.class).loadUserByUsername(username);
            if (moyJwtService.validateToken(token, userDetails)){

                User user = userRepo.findByUsername(username);
                HttpSession session = request.getSession();
                session.setAttribute("S_USERID", user.getUserId());
                session.setAttribute("S_UUID", user.getUuid());
                session.setAttribute("S_USERNAME", user.getUsername());
                logger.info("JWT Authenticated");
                System.out.println("SESSION ID: " + user.getUserId());
                System.out.println("SESSION NAME: " + user.getUsername());

                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
