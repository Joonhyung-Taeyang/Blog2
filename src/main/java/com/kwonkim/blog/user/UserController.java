package com.kwonkim.blog.user;

import com.kwonkim.blog.Response.ResponseCheck;
import com.kwonkim.blog.user.UserDto.UserCreate;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/user")
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/signin")
    @ResponseBody
    public ResponseEntity<ResponseCheck> SignIn(@RequestBody UserCreate userCreate)
    {
        // UserCreateCheck userCreate = userService.(userCreate)

        return ResponseEntity.ok(ResponseCheck.of(userCreate));
    }

    @GetMapping("/join")
    public String joinForm() {

        return "join";

    }

}
