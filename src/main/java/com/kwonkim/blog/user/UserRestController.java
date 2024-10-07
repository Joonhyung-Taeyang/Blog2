package com.kwonkim.blog.user;

import com.kwonkim.blog.Response.ResponseCheck;
import com.kwonkim.blog.user.UserDto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
     * @param userInfo 클라이언트로부터 username, password, email, nickname을 전달받음
     * @return HTTP 상태 코드 + 세부 메시지
     * @method POST
     */
    @PostMapping("/signup")
    public ResponseEntity<String> Signup(@RequestBody UserCreate userInfo) {

        switch (userService.Signup(userInfo)) {
            case 1:
                return ResponseEntity.ok("회원가입이 완료되었습니다.");
            case 2:
                return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 사용 중인 아이디입니다.");
            case 3:
                return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 사용 중인 이메일입니다.");
            case 4:
                return ResponseEntity.status(HttpStatus.CONFLICT).body("이미 사용 중인 닉네임입니다.");
        }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("예기치 못한 오류가 발생했습니다.");
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
