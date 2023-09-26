package com.smartcontact.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jakarta.servlet.annotation.WebFilter;

@Configuration
@WebFilter
public class FilterConfig {

    @Bean
    public FilterRegistrationBean<MyFilter> loggingFilter() {
        FilterRegistrationBean<MyFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new MyFilter());
        registrationBean.addUrlPatterns("/admin/*"); // Specify URL patterns to apply the filter to
        return registrationBean;
    }
    
    @Bean
    public FilterRegistrationBean<MyFilter1> loggingFilter1() {
        FilterRegistrationBean<MyFilter1> registrationBean1 = new FilterRegistrationBean<>();
        registrationBean1.setFilter(new MyFilter1());
        registrationBean1.addUrlPatterns("/admin/*"); // Specify URL patterns to apply the filter to
        return registrationBean1;
    }
    
    
}
