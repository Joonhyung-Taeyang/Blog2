package com.kwonkim.blog.user.UserDto;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class UserCreate {
    private String id;
    private String password;
    private String email;
    private String nickname;
}
