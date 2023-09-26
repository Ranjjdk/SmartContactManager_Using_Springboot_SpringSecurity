package com.smartcontact.filter;

import java.io.IOException;
import java.util.Enumeration;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter
public class MyFilter implements Filter {
   
	
	@Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Enumeration<String> initParameterNames = filterConfig.getInitParameterNames();
        
        while (initParameterNames.hasMoreElements()) {
            String paramName = initParameterNames.nextElement();
            String paramValue = filterConfig.getInitParameter(paramName);

            // Now, you can work with paramName and paramValue
            System.out.println("Parameter Name: " + paramName);
            System.out.println("Parameter Value: " + paramValue);
        }
    }

    @Override
    public void doFilter(
            ServletRequest request,
            ServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {
        System.out.println("+++++++++++Filter0++++++++++"+request.getContentType());
        System.out.println("+++++++++++Filter0++++++++++"+request.getProtocol());
        chain.doFilter(request, response);
        System.out.println("+++++++++Response++++++++++++++"+response.getContentType());
    }

    @Override
    public void destroy() {
        System.out.println("+++++++Destroy+++++++++++++");
    }
}
