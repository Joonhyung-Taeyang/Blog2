package com.kwonkim.blog.user;

import com.kwonkim.blog.Response.ResponseCheck;
import com.kwonkim.blog.user.UserDto.UserCreate;
import com.kwonkim.blog.user.UserDto.UserCreateCheck;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.kwonkim.blog.Response.ResultCheck.CREATE_USER_SUCCESS;


@RequestMapping(value = "/api/user")
@RestController
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @PostMapping("/signin")
    public ResponseEntity<ResponseCheck> SignIn(@RequestBody UserCreate userInfo)
    {

        UserCreateCheck userCreate = userService.SignIn(userInfo);

        return ResponseEntity.ok(ResponseCheck.of(CREATE_USER_SUCCESS));
    }

}
