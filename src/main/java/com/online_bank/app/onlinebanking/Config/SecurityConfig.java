package com.online_bank.app.onlinebanking.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 1. Disable CSRF (Crucial for Postman POST requests to work)
                .csrf(csrf -> csrf.disable())

                // 2. Authorize the specific API path
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/bank/api/v1/**").permitAll() // Allow registration
                        .anyRequest().authenticated() // Protect everything else
                );

        return http.build();
    }
}
