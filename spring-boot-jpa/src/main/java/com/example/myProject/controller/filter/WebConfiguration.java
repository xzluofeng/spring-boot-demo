package com.example.myProject.controller.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Configuration
public class WebConfiguration {
//    @Bean
//    public RemoteIpFilter remoteIpFilter() {
//        return new RemoteIpFilter();
//    }
//
//    @Bean
//    public FilterRegistrationBean testFilterRegistration() {
//        FilterRegistrationBean registration  = new FilterRegistrationBean();
//        registration.setFilter(new MyFilter());
//        registration.addUrlPatterns("/*");
//        registration.addInitParameter("paramName", "paramValue");
//        registration.setName("MyFilter");
//        registration.setOrder(1);
//        return registration;
//    }
    @Component
    @WebFilter(urlPatterns = "/*", filterName = "myFilter")
    @Order(1)
    public class MyFilter implements Filter {
        @Override
        public void init(FilterConfig filterConfig) throws ServletException {

        }

        @Override
        public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain chain) throws IOException, ServletException {
            HttpServletRequest request = (HttpServletRequest) srequest;
            System.out.println("this is MyFilter,url :"+request.getRequestURI());
            chain.doFilter(srequest, sresponse);
        }

        @Override
        public void destroy() {

        }
    }

}
