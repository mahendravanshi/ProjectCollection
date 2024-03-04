package com.security;

import com.security.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
@Configuration
@EnableWebSecurity
public class JwtSecurityApplication {

	public static void main(String[] args) {

		SpringApplication.run(JwtSecurityApplication.class, args);
	}

   @Autowired
	private  UserDetailsServiceImpl userDetailsService;
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {
		return http
				.cors(AbstractHttpConfigurer::disable)
				.csrf(AbstractHttpConfigurer::disable)
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//        Set permissions on endpoints
				.authorizeHttpRequests(auth -> auth
//            our public endpoints
						.requestMatchers(HttpMethod.POST, "/api/auth/signup/**").permitAll()
						.requestMatchers(HttpMethod.POST, "/api/auth/login/**").permitAll()
						.requestMatchers(HttpMethod.GET, "/authentication-docs/**").permitAll()
//            our private endpoints
						.anyRequest().authenticated())
				.authenticationManager(authenticationManager)
				.build();
	}

	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
		AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
		authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(encode());
		return authenticationManagerBuilder.build();
	}

	@Bean
	public PasswordEncoder encode(){
		return new BCryptPasswordEncoder();
	}





}
