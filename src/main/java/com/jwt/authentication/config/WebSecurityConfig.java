package com.jwt.authentication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.jwt.authentication.filter.JwtAuthFilter;
import com.jwt.authentication.service.CustomUserDetailService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Autowired
	private JwtAuthFilter authFilter;
	
	
	// User Creation
//	@Bean
//	public UserDetailsService userDetailsService() {
//		return new CustomUserDetailService();
//	}

	// Configuring HttpSecurity
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

//		System.out.println("+++++++++++++++filterChain(HttpSecurity http)+++++++called");
//		http.authorizeHttpRequests(authorize -> authorize
//				 .requestMatchers("/welcome", "/generateToken").permitAll()
//				 .requestMatchers("/admin")
//				.hasAuthority("Admin").requestMatchers("/manager").
//				hasAuthority("Manager").
//			anyRequest().authenticated())
//           .authenticationProvider(authenticationProvider());
//		   http.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);
		
		http.csrf(csrf->csrf.disable())
		.cors(cors->cors.disable())
		.authorizeHttpRequests(auth->auth.requestMatchers("/generateToken").permitAll()
				.requestMatchers("/welcome").authenticated()).
		sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);
		

		return http.build();

	}
	
	 @Bean
	  public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	  }
 
	 @Bean
	    public UserDetailsService userDetailsService() {
	        
	        UserDetails peter = User.builder().username("peter").password(passwordEncoder().encode("peter@123")).roles("USER")
	                .build();
	        
	        UserDetails admin = User.builder().username("admin").password(passwordEncoder().encode("admin")).roles("ADMIN")
	                .build();
	        return new InMemoryUserDetailsManager(peter,admin);
	    }
	

	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
		return config.getAuthenticationManager();
	}

}
