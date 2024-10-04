package com.kwonkim.blog.user;

import com.kwonkim.blog.user.UserDto.UserCreate;
import com.kwonkim.blog.user.UserDto.UserCreateCheck;
import com.kwonkim.blog.user.UserDto.UserLogIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.kwonkim.blog.Response.ErrorCheck.USER_USERNAME_NOTFOUND;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public int Signup(UserCreate userInfo) {
        User newUser = User.builder()
                .username(userInfo.getUsername())
                .password(userInfo.getPassword())
                .email(userInfo.getEmail())
                .nickname(userInfo.getNickname())
                .build();

        if(userRepository.existsByUsername(newUser.getUsername()))
        {
            return 2;
        }
        else if(userRepository.existsByEmail(newUser.getEmail()))
        {
            return 3;
        }
        else if(userRepository.existsByNickname(newUser.getNickname()))
        {
            return 4;
        }

        userRepository.save(newUser);

        return 1;
    }

    public int LogIn(UserLogIn userInfo)
    {
        User findUser = userRepository.findByUsername(userInfo.getUsername());

        if(!findUser.equals(null) && findUser.getPassword().equals(userInfo.getPassword()))
        {
            return 1;
        }
        else if(!findUser.getPassword().equals(userInfo.getPassword()))
        {
            return 3;
        }
        else
        {
            return 4;
        }
    }
}
