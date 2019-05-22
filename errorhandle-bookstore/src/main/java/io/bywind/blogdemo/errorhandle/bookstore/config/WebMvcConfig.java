package io.bywind.blogdemo.errorhandle.bookstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import io.bywind.blogdemo.errorhandle.commons.web.interceptor.RequestIdInterceptor;

/**
 * Created on Oct 09, 2018
 *
 * @author Chuan Qin
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestIdInterceptor());
    }


    @Bean
    public RequestIdInterceptor requestIdInterceptor() {
        return new RequestIdInterceptor();
    }
}
