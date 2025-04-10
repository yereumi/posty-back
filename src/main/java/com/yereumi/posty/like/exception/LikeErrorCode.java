package com.yereumi.posty.like.exception;

import com.yereumi.posty.common.exception.runtime.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LikeErrorCode implements ErrorCode {

    NOT_FOUND_TARGET("해당 타겟을 찾을 수 없습니다.", "LIKE-001");

    private final String message;
    private final String code;
}
