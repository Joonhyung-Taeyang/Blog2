package com.kwonkim.blog.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/joinForm")
    public String joinForm() {
        return "join";
    }

    @GetMapping("/loginFrom")
    public String loginForm() {
        return "login";
    }
}
