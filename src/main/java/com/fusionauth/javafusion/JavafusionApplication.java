package com.fusionauth.javafusion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavafusionApplication  {

	public static void main(String[] args) {
		SpringApplication.run(JavafusionApplication.class, args);
	}

	// @Override
	// protected void configure(HttpSecurity http) throws Exception {
	// 	// @formatter:off
	// 	http
	// 		.authorizeRequests(a -> a
	// 			.antMatchers("/", "/error", "/webjars/**").permitAll()
	// 			.anyRequest().authenticated()
	// 		)
	// 		.exceptionHandling(e -> e
	// 			.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
	// 		)
	// 		.csrf(c -> c
	// 			.csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
	// 		)
	// 		.logout(l -> l
	// 			.logoutSuccessUrl("/").permitAll()
	// 		)
	// 		.oauth2Login();
	// 	// @formatter:on
	// }

}
