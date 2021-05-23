package com.example.demo.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class WebExceptionHandler {

    @ExceptionHandler
    public AjaxResponseBean customException(
            CustomExceptionBean customExceptionBean
    ) {
        customExceptionBean.setCode(400);
        return AjaxResponseBean.error(customExceptionBean);
    }
}
