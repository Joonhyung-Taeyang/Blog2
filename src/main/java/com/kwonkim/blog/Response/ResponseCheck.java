package com.kwonkim.blog.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCheck {

    private int status;
    private String message;

    public static ResponseCheck of(ResultCheck resultCheck) {
        return new ResponseCheck(resultCheck);
    }

    public ResponseCheck(ResultCheck resultCheck) {
        this.status = resultCheck.getStatus();
        this.message = resultCheck.getMessage();
    }

}
