package com.example;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LoggingFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("LoggingFilter: Received a request.");

        System.out.println("Request Path: " + ((HttpServletRequest) request).getRequestURI());

        System.out.println("Request Headers:");
        Enumeration<String> headerNames = ((HttpServletRequest) request).getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            System.out.println(headerName + ": " + ((HttpServletRequest) request).getHeader(headerName));
        }

        chain.doFilter(request, response);

    }

}
