package com.fusionauth.javafusion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfiguration {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    // http
    //     .authorizeHttpRequests((authz) -> authz
    //         .antMatchers("/").permitAll()
    //         .anyRequest().authenticated()
    //         //.oauth2Client(withDefaults()));
    // http.authorizeRequests()
    //   .antMatchers("/")
    //   .permitAll()
    //   .and()
    //   .authorizeRequests()
    //   .anyRequest()
    //   .authenticated()
    //   .and()
    //   .oauth2Client(withDefaults());
    
    http
    .authorizeRequests(a -> a
      .antMatchers("/").permitAll()
      .anyRequest().authenticated()
    )
    .oauth2Login();

    return http.build();
  }
}