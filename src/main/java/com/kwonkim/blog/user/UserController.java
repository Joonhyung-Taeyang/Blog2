package com.kwonkim.blog.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    @GetMapping("/join")
    public String joinForm() {
        return "join";
    }

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

}
