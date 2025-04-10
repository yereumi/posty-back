package com.yereumi.posty.user.domain;

import com.yereumi.posty.common.exception.runtime.BaseException;
import com.yereumi.posty.user.exception.UserErrorCode;
import java.util.Arrays;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Provider {

    KAKAO("카카오"), GOOGLE("구글");

    private final String provider;

    public static Provider of(String provider) {
        return Arrays.stream(values())
            .filter(p -> p.equals(provider))
            .findAny()
            .orElseThrow(() -> new BaseException(UserErrorCode.NOT_FOUNT_PROVIDER));
    }
}
