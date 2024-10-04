package com.kwonkim.blog.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCheck {
    USER_ID_DUPLICATION(2, "아이디 중복"),
    USER_NICKNAME_DUPLICATION(3, "닉네임중복"),
    USER_EMAIL_DUPLICATION(4, "이메일 중복"),

    ;

    private final int status;
    private final String message;
}
