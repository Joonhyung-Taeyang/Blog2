package com.kwonkim.blog.user;

import com.kwonkim.blog.Response.ResponseCheck;
import com.kwonkim.blog.user.UserDto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.kwonkim.blog.Response.ErrorCheck.*;
import static com.kwonkim.blog.Response.ResultCheck.*;


@RequestMapping(value = "/api/user")
@RestController
@RequiredArgsConstructor
public class UserRestController {

    @Autowired
    private final UserService userService;

    /**
     * 사용자 회원가입 요청을 받는 컨트롤러
     *
     * @method POST
     * @param userInfo 클라이언트로부터 username, password, email, nickname을 전달받음
     * @return 1: 정상 가입, 2: 중복된 아이디, 3: 중복된 이메일, 4: 중복된 닉네임
     */
    @PostMapping("/signup")
    public ResponseEntity<ResponseCheck> Signup(@RequestBody UserCreate userInfo) {

        int check = userService.Signup(userInfo);

        switch (check) {
            case 1:
                return ResponseEntity.ok(ResponseCheck.Normal(CREATE_USER_SUCCESS));
            case 2:
                return ResponseEntity.ok(ResponseCheck.Error(USER_USERNAME_DUPLICATION));
            case 3:
                return ResponseEntity.ok(ResponseCheck.Error(USER_EMAIL_DUPLICATION));
            case 4:
                return ResponseEntity.ok(ResponseCheck.Error(USER_NICKNAME_DUPLICATION));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseCheck> LogIn(@RequestBody UserLogIn loginInfo) {
        int check = userService.LogIn(loginInfo);

        if (check == 2) {
            return ResponseEntity.ok(ResponseCheck.Error(USER_USERNAME_NOTFOUND));
        }
        if (check == 3) {
            return ResponseEntity.ok(ResponseCheck.Error(USER_PASSWORD_INCOREECT));
        }

        return ResponseEntity.ok(ResponseCheck.Normal(LOGIN_USER_SUCCESS));
    }

    @PostMapping("/deleteuser")
    public ResponseEntity<ResponseCheck> Resign(@RequestBody UserDeleteCheck userResign) {
        int check = userService.Resign(userResign);

        if (check == 2) {
            return ResponseEntity.ok(ResponseCheck.Error(USER_USERNAME_NOTFOUND));
        }

        return ResponseEntity.ok(ResponseCheck.Normal(RESIGN_USER_SUCCESS));
    }

    @GetMapping("/finduser")
    public ResponseEntity<ResponseCheck> findUser(@RequestBody UserFindRequest userInfo) {
        UserFindResponse userFindResponse = userService.SelectUsername(userInfo);

        if (userFindResponse.isCheck() == false) {
            return ResponseEntity.ok(ResponseCheck.Error(USER_EMAIL_NOTFOUND));
        }

        return ResponseEntity.ok(ResponseCheck.Data(FIND_USER_USERNAME_SUCCESS, userFindResponse));
    }

    @PostMapping("/updatepw")
    public ResponseEntity<ResponseCheck> changePW(@RequestBody UserChangePW userInfo) {
        int check = userService.ChangePW(userInfo);

        if (check == 2) {
            return ResponseEntity.ok(ResponseCheck.Error(USER_USERNAME_NOTFOUND));
        } else if (check == 3) {
            return ResponseEntity.ok(ResponseCheck.Error(USER_EMAIL_NOTFOUND));
        }

        return ResponseEntity.ok(ResponseCheck.Normal(CHANGE_USER_PASSWORD_SUCCESS));
    }
}
