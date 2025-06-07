package com.auth.service.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public BCryptPasswordEncoder  bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
      return   httpSecurity
              .csrf(csrf->csrf.disable())
                .authorizeHttpRequests( authorize-> authorize
                      //  .requestMatchers("/api/v1/auth/passenger/**").permitAll()
                        .requestMatchers("/api/v1/auth/passenger/**").permitAll()
                        .anyRequest().authenticated()
                 ).build();

    }
}
