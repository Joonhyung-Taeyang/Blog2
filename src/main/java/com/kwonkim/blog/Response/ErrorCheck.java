package com.kwonkim.blog.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCheck {
    USER_USERNAME_DUPLICATION(401, "유저 네임 중복"),
    USER_EMAIL_DUPLICATION(401, "이메일 중복"),
    USER_NICKNAME_DUPLICATION(401, "닉네임 중복"),
    USER_USERNAME_NOTFOUND(401, "유저 네임을 찾을 수 없음"),
    USER_PASSWORD_INCOREECT(401, "잘못된 비밀번호"),

    ;

    private final int status;
    private final String message;
}
