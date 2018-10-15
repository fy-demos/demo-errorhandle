package com.lomagicode.example.errorhandle.bookstore.error;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

import com.lomagicode.example.errorhandle.commons.error.CustomizedBaseExceptionHandler;

/**
 * Created on Oct 15, 2018
 *
 * @author Chuan Qin
 */
@ControllerAdvice
@RestController
public class RestExceptionHandler extends CustomizedBaseExceptionHandler {
}
