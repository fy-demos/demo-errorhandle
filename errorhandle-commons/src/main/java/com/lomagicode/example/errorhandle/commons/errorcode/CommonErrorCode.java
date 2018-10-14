package com.lomagicode.example.errorhandle.commons.errorcode;

/**
 * Created on Oct 10, 2018
 *
 * @author Chuan Qin
 */
public enum CommonErrorCode implements ErrorCode {
    /**
     * 错误请求
     */
    INVALID_REQUEST("InvalidRequest", "Invalid request."),
    /**
     * 参数验证错误
     */
    INVALID_ARGUMENT("InvalidArgument", "Invalid argument [{0}], hints: {1}"),
    /**
     * 未找到资源
     */
    NOT_FOUND("NotFound","Resource {0} not found."),
    /**
     * 未知错误
     */
    UNKNOWN_ERROR("UnknownError", "Unknown server internal error.");

    CommonErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    /**
     * Customized error code
     */
    private String code;
    /**
     * Error message details
     */
    private String message;


    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
