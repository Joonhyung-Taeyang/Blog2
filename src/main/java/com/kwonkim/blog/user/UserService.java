package com.kwonkim.blog.user;

import com.kwonkim.blog.user.UserDto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
                .isDelete(false)
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
        if(userRepository.existsByUsername(userInfo.getUsername()) == false)
        {
            return 2;
        }

        User findUser = userRepository.findByUsername(userInfo.getUsername());

        if(findUser.isDelete() == true)
        {
            return 2;
        }
        else if(!findUser.getPassword().equals(userInfo.getPassword()))
        {
            return 3;
        }
        else if(!findUser.equals(null) && findUser.getPassword().equals(userInfo.getPassword()))
        {
            return 1;
        }
        else
        {
            return 4;
        }
    }

    public int Resign(UserDeleteCheck userInfo)
    {
        if(userRepository.existsByUsername(userInfo.getUsername()) == false)
        {
            return 2;
        }

        User user = userRepository.findByUsername(userInfo.getUsername());

        if(user.isDelete() == true)
        {
            return 2;
        }
        else
        {
            user.setDelete(true);

            userRepository.save(user);

            return 1;
        }
    }

    public UserFindResponse SelectUsername(UserFindRequest userInfo)
    {
        if (userRepository.existsByEmail(userInfo.getEmail()) == false)
        {
            UserFindResponse userFindResponse = new UserFindResponse();

            userFindResponse.setCheck(false);

            return userFindResponse;
        }
        else
        {
            User user = userRepository.findByEmail(userInfo.getEmail());

            return UserFindResponse.builder()
                    .username(user.getUsername())
                    .check(true)
                    .build();
        }
    }


    public int ChangePW(UserChangePW userInfo) {

        UserFindRequest userFindRequest = UserFindRequest.builder().email(userInfo.getEmail()).build();

        UserFindResponse userFindResponse = SelectUsername(userFindRequest);

        if
        (userRepository.existsByEmail(userFindResponse.getUsername()) == false)
        {
            return 3;
        }

        User user = userRepository.findByUsername(userFindResponse.getUsername());

        if (user.isDelete() == true)
        {
            return 2;
        }
        else
        {
            user.setPassword(userInfo.getPassword());

            userRepository.save(user);

            return 1;
        }
    }
}
