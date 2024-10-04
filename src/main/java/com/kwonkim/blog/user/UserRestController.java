package com.kwonkim.blog.user;

import com.kwonkim.blog.Response.ResponseCheck;
import com.kwonkim.blog.user.UserDto.UserCreate;
import com.kwonkim.blog.user.UserDto.UserCreateCheck;
import com.kwonkim.blog.user.UserDto.UserLogIn;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.kwonkim.blog.Response.ErrorCheck.*;
import static com.kwonkim.blog.Response.ResultCheck.CREATE_USER_SUCCESS;
import static com.kwonkim.blog.Response.ResultCheck.LOGIN_USER_SUCCESS;


@RequestMapping(value = "/api/user")
@RestController
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<ResponseCheck> Signup(@RequestBody UserCreate userInfo)
    {

        int check = userService.Signup(userInfo);

        if(check == 2)
        {
            return ResponseEntity.ok(ResponseCheck.Error(USER_USERNAME_DUPLICATION));
        }
        else if(check == 3)
        {
            return ResponseEntity.ok(ResponseCheck.Error(USER_EMAIL_DUPLICATION));
        }
        else if(check == 4)
        {
            return ResponseEntity.ok(ResponseCheck.Error(USER_NICKNAME_DUPLICATION));
        }

        return ResponseEntity.ok(ResponseCheck.Normal(CREATE_USER_SUCCESS));
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseCheck> LogIn(@RequestBody UserLogIn loginInfo)
    {
        int check = userService.LogIn(loginInfo);

/*        if(check == 2)
        {
            return ResponseEntity.ok(ResponseCheck.Error(USER_USERNAME_NOTFOUND));
        }*/
        if(check == 3)
        {
            return ResponseEntity.ok(ResponseCheck.Error(USER_PASSWORD_INCOREECT));
        }

        return ResponseEntity.ok(ResponseCheck.Normal(LOGIN_USER_SUCCESS));
    }


}
