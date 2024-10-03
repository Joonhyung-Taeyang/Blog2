package com.kwonkim.blog.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCheck {
    private Object data;

    public static ResponseCheck of(Object data)
    {
        return new ResponseCheck(data);
    }

/*    public ResponseCheck() {
        this.data = null;
    }*/

}
