package com.lomagicode.example.errorhandle.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.lomagicode.example.errorhandle.bookstore.web.interceptor.RequestIdInterceptor;

/**
 * Created on Oct 09, 2018
 *
 * @author Chuan Qin
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    private final RequestIdInterceptor requestIdInterceptor;

    @Autowired
    public WebMvcConfig(RequestIdInterceptor requestIdInterceptor) {
        this.requestIdInterceptor = requestIdInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestIdInterceptor);
    }
}
