package com.kwonkim.blog.user.UserDto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class UserLogIn {
    private String username;
    private String password;
}
