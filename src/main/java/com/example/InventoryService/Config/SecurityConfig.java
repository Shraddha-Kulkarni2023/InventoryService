package com.example.InventoryService.Config;

import com.example.InventoryService.Filter.JwtAuthenticationFilter;
import jakarta.servlet.Filter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
 public class SecurityConfig {

     @Bean
     public SecurityFilterChain filterChain(HttpSecurity http, JwtAuthenticationFilter jwtAuthenticationFilter) throws Exception {

         http
                 .csrf(csrf -> csrf.disable())
                 .authorizeHttpRequests(auth -> auth
                         .requestMatchers("/inventory/startinventory").permitAll()
                         .requestMatchers("/inventory/*").permitAll()
                         .anyRequest().authenticated()
                 )
                 .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

         return http.build();
     }
 }
