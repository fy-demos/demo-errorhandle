package com.lomagicode.example.errorhandle.commons.error;


import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.util.WebUtils;

/**
 * 全局异常处理
 *
 * Created on Oct 09, 2018
 *
 * @author Chuan Qin
 */
public class CustomizedBaseExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(CustomizedBaseExceptionHandler.class);

    /**
     * 处理业务异常
     *
     * @param ex      the exception
     * @param request the current request
     * @return a {@code ResponseEntity} instance
     */
    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ErrorDetails> handleBusinessException(BusinessException ex, WebRequest request) {
        LOGGER.info("+++++++++++IN++++++handleBusinessException");
        ErrorDetails body = ErrorDetails.from(ex, request);
        HttpStatus status = ex.getStatus();
        ResponseEntity<ErrorDetails> responseEntity = new ResponseEntity<>(body, status);
        LOGGER.info("+++++++++++OUT++++++handleBusinessException");
        return responseEntity;
    }

    /**
     * 重写参数校验异常处理
     *
     * @param ex the exception
     * @param headers the http response headers
     * @param status the http response status
     * @param request the current request
     * @return a {@code ResponseEntity} instance
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        FieldError error = ex.getBindingResult().getFieldErrors().get(0);
        String field = error.getObjectName() + "." + error.getField();
        String hints = error.getDefaultMessage();
        ErrorDetails details = ErrorDetails.from(CommonErrorCode.INVALID_ARGUMENT, HttpStatus.BAD_REQUEST, request, field, hints);

        return handleExceptionInternal(ex, details, headers, status, request);
    }

    /**
     * 重写Spring内部的默认异常处理逻辑，使用自定义返回消息体
     *
     * @param ex the exception
     * @param body the http response body
     * @param headers the http response headers
     * @param status the http response status
     * @param request the current request
     * @return a {@code ResponseEntity} instance
     */
    @Override
    protected ResponseEntity<Object> handleExceptionInternal(
            Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatus status, WebRequest request) {
        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
        }
        //noinspection ConstantConditions
        if (Objects.isNull(body)) {
            ErrorDetails details = ErrorDetails.from(CommonErrorCode.INVALID_REQUEST, status, request, ex.getMessage());
            return new ResponseEntity<>(details, headers, status);
        }
        return new ResponseEntity<>(body, headers, status);
    }
}
