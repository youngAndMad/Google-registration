package com.example.demo.config;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests((req) ->
                        req.anyRequest().authenticated()
                ).oauth2Login((config) ->
                        config.loginProcessingUrl("/login")
                                .loginPage("/oauth2/authorization/google")
                                .successHandler(new AuthenticationSuccessHandler() {
                                                    @Override
                                                    public void onAuthenticationSuccess(HttpServletRequest request,
                                                                                        HttpServletResponse response,
                                                                                        Authentication authentication)
                                                            throws ServletException,
                                                            IOException {
                                                        request.authenticate(response);
                                                    }
                                                }
                                )
                ).build();
    }

}
