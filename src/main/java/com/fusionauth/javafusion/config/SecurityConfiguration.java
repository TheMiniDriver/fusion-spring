package com.fusionauth.javafusion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestCustomizers;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.client.web.server.DefaultServerOAuth2AuthorizationRequestResolver;
import org.springframework.security.oauth2.client.web.server.ServerOAuth2AuthorizationRequestResolver;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.server.SecurityWebFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfiguration {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http 
        //,DefaultOAuth2AuthorizationRequestResolver resolver 
  ) 
  throws Exception {
    http
        .authorizeRequests(a -> a
            .antMatchers("/").permitAll()
            .anyRequest().authenticated())
        .oauth2Login();

       // resolver.setAuthorizationRequestCustomizer(OAuth2AuthorizationRequestCustomizers.withPkce());

    return http.build();
  }

  // @Bean
  // public DefaultOAuth2AuthorizationRequestResolver pkceResolver(ClientRegistrationRepository repo) {
  //   var resolver = new DefaultOAuth2AuthorizationRequestResolver(repo, "https://fusionauth.ritza.co");
  //   resolver.setAuthorizationRequestCustomizer(OAuth2AuthorizationRequestCustomizers.withPkce());
  //   return resolver;
  // }

  // @Bean
  // public OAuth2AuthorizationRequestResolver pkceResolver(ClientRegistrationRepository repo) {
  //   var resolver = new DefaultOAuth2AuthorizationRequestResolver(repo);
  //   resolver.setAuthorizationRequestCustomizer(OAuth2AuthorizationRequestCustomizers.withPkce());
  //   return resolver;
  // }

  // @Bean
  // public SecurityWebFilterChain pkceFilterChain(ServerHttpSecurity http,
  //     ServerOAuth2AuthorizationRequestResolver resolver) {
  //   http.authorizeExchange(r -> r.anyExchange().authenticated());
  //   http.oauth2Login(auth -> auth.authorizationRequestResolver(resolver));
  //   return http.build();
  // }

  // @Bean
  // public ServerOAuth2AuthorizationRequestResolver pkceResolver(ReactiveClientRegistrationRepository repo) {
  //   var resolver = new DefaultServerOAuth2AuthorizationRequestResolver(repo);
  //   resolver.setAuthorizationRequestCustomizer(OAuth2AuthorizationRequestCustomizers.withPkce());
  //   return resolver;
  // }

}