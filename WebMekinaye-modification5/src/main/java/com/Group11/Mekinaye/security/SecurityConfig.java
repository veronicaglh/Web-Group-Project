package com.Group11.Mekinaye.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    PasswordEncoder bcryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
 
   
    
    
    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepo) {
        return username -> {
            User user = userRepo.findByUsername(username);
            if (user != null)
                return user;
 
            throw new UsernameNotFoundException(
 "User '" + username + "' not found");
        };
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests()
                .antMatchers("/service", "/order/*").hasRole("USER")
                .antMatchers("/service", "/order/*").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "{user}").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "{user}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "{user}").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "{user}").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "{user}").hasRole("USER")
                .antMatchers("/", "/**").permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/service")
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .build();
    }
}

 
 

