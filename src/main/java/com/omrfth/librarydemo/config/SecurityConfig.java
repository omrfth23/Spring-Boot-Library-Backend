package com.omrfth.librarydemo.config;

import com.omrfth.librarydemo.model.Member;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {
    @Bean
    UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }


    @Bean
    public InMemoryUserDetailsManager userDetailManager () {

        UserDetails johnny = User.builder()
                .username("johnny")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();
        UserDetails omer = User.builder()
                .username("omer")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();
        UserDetails daffy = User.builder()
                .username("daffy")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        return new InMemoryUserDetailsManager(johnny, omer, daffy);

    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/api/books").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "/api/books/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "/api/books").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/books").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/books/**").hasRole("ADMIN")

        );
        httpSecurity.httpBasic(Customizer.withDefaults());
        httpSecurity.csrf(csrf -> csrf.disable());
        return httpSecurity.build();
    }


}
