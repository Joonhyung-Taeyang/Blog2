package com.kwonkim.blog.user;

import com.kwonkim.blog.user.UserDto.UserCreate;
import com.kwonkim.blog.user.UserDto.UserCreateCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserCreateCheck SignIn(UserCreate userInfo) {
        User newUser = User.builder()
                .username(userInfo.getUsername())
                .password(userInfo.getPassword())
                .email(userInfo.getEmail())
                .nickname(userInfo.getNickname())
                .build();

        userRepository.save(newUser);

        UserCreateCheck returnUser = new UserCreateCheck();

        return returnUser.builder()
                .id(newUser.getId())
                .build();
    }

}
