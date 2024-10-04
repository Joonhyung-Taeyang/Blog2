package com.kwonkim.blog.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCheck {
    CREATE_USER_SUCCESS(1, "사용자 추가 성공")

    ;

    private final int status;
    private final String message;
}
