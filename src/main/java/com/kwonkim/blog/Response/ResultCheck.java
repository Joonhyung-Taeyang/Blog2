package com.kwonkim.blog.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCheck {
    CREATE_USER_SUCCESS(200, "사용자 추가 성공"),
    LOGIN_USER_SUCCESS(200, "사용자 로그인 성공"),
    RESIGN_USER_SUCCESS(200, "사용자 탈퇴 성공"),
    CHANGE_USER_PASSWORD_SUCCESS(200, "사용자 비밀번호 변경 성공"),
    FIND_USER_USERNAME_SUCCESS(200, "사용자 유저 이름 찾기 성공"),

    ;

    private final int status;
    private final String message;
}
