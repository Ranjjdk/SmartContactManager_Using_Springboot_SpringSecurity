package com.smartcontact.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

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
               .requestMatchers("/about", "/signup", "/", "/do-register").permitAll().requestMatchers("/admin")
				.hasAuthority("Admin").requestMatchers("/manager").
				hasAuthority("Manager").
			anyRequest().authenticated())
		       .formLogin(formLogin -> formLogin.permitAll())
				.authenticationProvider(authenticationProvider());

		return http.build();

	}
	
	
//	public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/login").setViewName("login");
//        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
//    }

	@Bean
	public AuthenticationProvider authenticationProvider() {

		System.out.println("++++++++++++++++++authenticationProvider()+++++++++++++++ called+++++++");

		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(uds);
		authenticationProvider.setPasswordEncoder(encoder);
		return authenticationProvider;
	}
}