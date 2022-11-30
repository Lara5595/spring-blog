package com.codeup.springblog.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .antMatchers("/posts/create", "/posts/{post.id}/edit").authenticated()
                .antMatchers("/", "/register", "/posts", "/posts/{id}").permitAll()
                .and().formLogin()
                .and().httpBasic();
//        We added .login page so we can use our login page and redirect to posts
        http.formLogin().loginPage("/login").defaultSuccessUrl("/posts").and().logout();
        http.httpBasic();
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

}// End of securityConfig


// antMatches will get replace by requestMatcher()