package com.yereumi.posty.common.exception.runtime;

public record ExceptionResponse(
    String errorCode,
    String message
) {

}
