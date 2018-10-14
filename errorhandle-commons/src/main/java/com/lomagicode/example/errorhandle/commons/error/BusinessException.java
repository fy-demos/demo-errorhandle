package com.lomagicode.example.errorhandle.commons.error;


import org.springframework.http.HttpStatus;

/**
 * Created on Oct 09, 2018
 *
 * @author Chuan Qin
 */
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1478021026550689582L;

    public static final HttpStatus DFLT_HTTP_STATUS = HttpStatus.INTERNAL_SERVER_ERROR;

    private ErrorCode errorCode;
    private HttpStatus status;
    private Object[] args;

    public static BusinessException of(ErrorCode errorCode) {
        return of(errorCode, DFLT_HTTP_STATUS);
    }

    public static BusinessException of(ErrorCode errorCode, HttpStatus status) {
        BusinessException ex = new BusinessException();
        ex.setErrorCode(errorCode);
        ex.setStatus(status);
        return ex;
    }

    public static BusinessException of(ErrorCode errorCode, Object... args) {
        return of(errorCode, DFLT_HTTP_STATUS, args);
    }

    public static BusinessException of(ErrorCode errorCode, HttpStatus status, Object... args) {
        BusinessException ex = new BusinessException();
        ex.setErrorCode(errorCode);
        ex.setStatus(status);
        ex.setArgs(args);
        return ex;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}
