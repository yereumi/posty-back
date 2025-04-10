package com.yereumi.posty.like.domain;

import com.yereumi.posty.common.exception.runtime.BaseException;
import com.yereumi.posty.like.exception.LikeErrorCode;
import java.util.Arrays;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Target {

    POST("게시물"), COMMENT("댓글");

    private final String target;

    public static Target of(String target) {
        return Arrays.stream(values())
            .filter(t -> t.equals(target))
            .findAny()
            .orElseThrow(() -> new BaseException(LikeErrorCode.NOT_FOUND_TARGET));
    }
}
