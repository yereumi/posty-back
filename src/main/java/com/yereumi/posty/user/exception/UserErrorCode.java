package com.yereumi.posty.user.exception;

import com.yereumi.posty.common.exception.runtime.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UserErrorCode implements ErrorCode {

    NOT_FOUNT_PROVIDER("해당하는 소셜을 찾을 수 없습니다.", "USER-001");

    private final String message;
    private final String code;
}
