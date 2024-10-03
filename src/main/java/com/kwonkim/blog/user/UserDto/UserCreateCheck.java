package com.kwonkim.blog.user.UserDto;

import lombok.*;

import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
public class UserCreateCheck {
    private UUID user_uuid;
}
