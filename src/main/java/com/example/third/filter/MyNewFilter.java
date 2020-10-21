package com.example.third.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
@Component
public class MyNewFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("new filter is called");
        filterChain.doFilter(servletRequest,servletResponse);
    }
}
