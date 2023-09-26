////package com.smartcontact.config;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//@Configuration
//
//public class WebSecurityConfig {
// 
// @Autowired
//    UserDetailsService userDetailsService;
//
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//        .authorizeHttpRequests()
//            .antMatchers("/", "/home", "/public/**").permitAll()
//            .antMatchers("/users/**").hasAuthority("ADMIN")
//            .anyRequest().fullyAuthenticated()
//            .and()
//        .formLogin()
//            .loginPage("/login")
//            .failureUrl("/login?error")
//            .usernameParameter("email")
//            .permitAll()
//            .and()
//        .logout()
//         .logoutUrl("/logout")
//            .logoutSuccessUrl("/")
//            .permitAll();
//    }
//
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .userDetailsService(userDetailsService)
//                .passwordEncoder(new BCryptPasswordEncoder());
//    }
//}
