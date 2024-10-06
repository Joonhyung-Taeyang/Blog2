package com.kwonkim.blog.user.UserDto;

import lombok.*;

@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserFindResponse {
    private String username;
    private boolean check;
}
