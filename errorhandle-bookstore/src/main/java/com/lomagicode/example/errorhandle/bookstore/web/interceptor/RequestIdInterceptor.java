package com.lomagicode.example.errorhandle.bookstore.web.interceptor;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.lomagicode.example.errorhandle.commons.constant.WebConsts;

/**
 * Created on Oct 09, 2018
 *
 * @author Chuan Qin
 */
@Component
public class RequestIdInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute(WebConsts.ATTR_REQUEST_ID, UUID.randomUUID().toString());
        return true;
    }
}
