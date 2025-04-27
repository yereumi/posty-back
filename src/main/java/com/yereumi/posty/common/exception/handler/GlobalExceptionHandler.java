package com.yereumi.posty.common.exception.handler;

import com.yereumi.posty.common.exception.runtime.BaseException;
import com.yereumi.posty.common.exception.runtime.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BaseException.class)
    public ExceptionResponse customException(BaseException baseException) {
        return new ExceptionResponse(baseException.getCode(), baseException.getMessage());
    }
}
