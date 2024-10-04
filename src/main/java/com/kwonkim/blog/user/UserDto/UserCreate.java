package com.kwonkim.blog.user.UserDto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class UserCreate {
    private String username;
    private String password;
    private String email;
    private String nickname;
}
