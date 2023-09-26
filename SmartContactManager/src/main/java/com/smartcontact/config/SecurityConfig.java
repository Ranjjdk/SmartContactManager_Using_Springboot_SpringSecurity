package com.smartcontact.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

	@Autowired
	private UserDetailsService uds;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		
		System.out.println("+++++++++++++++filterChain(HttpSecurity http)+++++++called");
		http.authorizeHttpRequests(authorize -> authorize
				
				.requestMatchers("/home", "/register", "/saveUser","/save")
				.permitAll()
				.requestMatchers("/welcome").authenticated()
				.requestMatchers("/admin").hasAuthority("Admin")
				.requestMatchers("/mgr").hasAuthority("Manager")
				.requestMatchers("/emp").hasAuthority("Employee")
				.requestMatchers("/hr").hasAuthority("HR").requestMatchers("/common")
				.hasAnyAuthority("Employeee,Manager,Admin").anyRequest().authenticated())
				.formLogin(formLogin -> formLogin
				.permitAll())
				.authenticationProvider(authenticationProvider());

		return http.build();

	}

	@Bean
	public AuthenticationProvider authenticationProvider() {
		
		System.out.println("++++++++++++++++++authenticationProvider()+++++++++++++++ called+++++++");
		
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(uds);
		authenticationProvider.setPasswordEncoder(encoder);
		return authenticationProvider;
	}
}