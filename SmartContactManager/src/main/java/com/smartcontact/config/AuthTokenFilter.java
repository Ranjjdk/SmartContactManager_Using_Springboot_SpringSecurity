//package com.smartcontact.config;
//
//import java.io.IOException;
//
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@Component
//public class AuthTokenFilter extends OncePerRequestFilter {
//
//   
////	@Autowired
////    private AuthenticationManager authenticationManager;
//
//    @Override
//    protected void doFilterInternal(
//            HttpServletRequest request,
//            HttpServletResponse response,
//            FilterChain filterChain
//    ) throws ServletException, IOException {
//        try {
//            // Extract the username and password from the request
//            String username = extractUsername(request);
//            String password = extractPassword(request);
//
//            if (username != null && password != null) {
//                // Create an authentication token with the username and password
//                Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);
//
//                // Authenticate the user using the AuthenticationManager
//                Authentication authenticated = authenticationManager.authenticate(authentication);
//
//                // Set the authenticated user in the SecurityContext
//                SecurityContextHolder.getContext().setAuthentication(authenticated);
//            }
//        } catch (Exception e) {
//            // Handle authentication errors or unauthorized access
//            SecurityContextHolder.clearContext();
//        }
//
//        filterChain.doFilter(request, response);
//    }
//    
//    
//    private String extractUsername(HttpServletRequest request) {
//        return request.getParameter("username");
//    }
//
//    private String extractPassword(HttpServletRequest request) {
//        return request.getParameter("password");
//    }
//
//
//	
//	
//}
