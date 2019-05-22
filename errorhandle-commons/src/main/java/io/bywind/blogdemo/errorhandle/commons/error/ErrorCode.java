package io.bywind.blogdemo.errorhandle.commons.error;

/**
 * 错误码接口，凡各模块错误码枚举类，皆须为此接口的子类型
 *
 * Created on Oct 09, 2018
 *
 * @author Chuan Qin
 *
 * @see CommonErrorCode
 */
public interface ErrorCode {

    String getCode();

    String getMessage();
}
