package io.bywind.blogdemo.errorhandle.commons.error;

import java.text.MessageFormat;
import java.time.ZonedDateTime;
import java.util.Objects;

import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;

import io.bywind.blogdemo.errorhandle.commons.constant.WebConsts;

import lombok.Data;

/**
 * 错误响应消息体，可根据需要定制
 *
 * Created on Oct 09, 2018
 *
 * @author Chuan Qin
 */
@Data
public class ErrorDetails {
    private String requestId;
    private Integer status;
    private String reason;
    private String code;
    private String message;
    private String details;
    private ZonedDateTime timestamp = ZonedDateTime.now();

    public static ErrorDetails from(ErrorCode errorCode, WebRequest request) {
        BusinessException ex = BusinessException.of(errorCode);
        return ErrorDetails.from(ex, request);
    }

    public static ErrorDetails from(ErrorCode errorCode, WebRequest request, Object... args) {
        BusinessException ex = BusinessException.of(errorCode, args);
        return ErrorDetails.from(ex, request);
    }

    public static ErrorDetails from(ErrorCode errorCode, HttpStatus status, WebRequest request) {
        BusinessException ex = BusinessException.of(errorCode, status);
        return ErrorDetails.from(ex, request);
    }

    public static ErrorDetails from(ErrorCode errorCode, HttpStatus status, WebRequest request, Object... args) {
        BusinessException ex = BusinessException.of(errorCode, status, args);
        return ErrorDetails.from(ex, request);
    }

    public static ErrorDetails from(BusinessException ex, WebRequest request) {
        ErrorDetails details = new ErrorDetails();
        details.setCode(ex.getErrorCode().getCode());
        Object[] args = ex.getArgs();
        if (Objects.isNull(args) || args.length <= 0) {
            details.setMessage(ex.getErrorCode().getMessage());
        } else {
            String message = MessageFormat.format(ex.getErrorCode().getMessage(), args);
            details.setMessage(message);
        }
        details.setStatus(ex.getStatus().value());
        details.setReason(ex.getStatus().getReasonPhrase());
        details.setRequestId((String) request.getAttribute(WebConsts.ATTR_REQUEST_ID, WebRequest.SCOPE_REQUEST));
        details.setDetails(request.getDescription(true));
        return details;
    }
}
