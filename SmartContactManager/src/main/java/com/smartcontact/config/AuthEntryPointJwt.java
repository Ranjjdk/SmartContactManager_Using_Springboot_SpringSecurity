//package com.smartcontact.config;
//
//import java.io.IOException;
//
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.AuthenticationEntryPoint;
//import org.springframework.stereotype.Component;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@Component
//public class AuthEntryPointJwt implements AuthenticationEntryPoint {
//
//    @Override
//    public void commence(HttpServletRequest request, HttpServletResponse response,
//                         AuthenticationException authException) throws IOException, ServletException {
////        // Customize the response for unauthorized requests here
////        // For example, you might set the response status and send an error message
//        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
////    	response.sendRedirect("/login");
//    }
//}
