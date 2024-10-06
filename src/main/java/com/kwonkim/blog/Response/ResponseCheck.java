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
    private Object data;

    public static ResponseCheck Normal(ResultCheck resultCheck) {
        return new ResponseCheck(resultCheck);
    }

    public static  ResponseCheck Error(ErrorCheck errorCheck)
    {
        return new ResponseCheck(errorCheck);
    }

    public static ResponseCheck Data(ResultCheck resultCheck, Object data)
    {
        return new ResponseCheck(resultCheck, data);
    }

    public ResponseCheck(ResultCheck resultCheck) {
        this.status = resultCheck.getStatus();
        this.message = resultCheck.getMessage();
    }

    public ResponseCheck(ErrorCheck errorCheck) {
        this.status = errorCheck.getStatus();
        this.message = errorCheck.getMessage();
    }

    public ResponseCheck(ResultCheck resultCheck, Object data)
    {
        this.status = resultCheck.getStatus();
        this.message = resultCheck.getMessage();
        this.data = data;
    }

}
