package com.zht.jwt.vo;

import lombok.Data;

@Data
public class ApiResponseVO {

    private int code;

    private String msg;

    private Object data;

    public ApiResponseVO(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static ApiResponseVO fail(Object data) {
        return fail(null, data);
    }

    public static ApiResponseVO fail(String msg) {
        return fail(msg, null);
    }

    public static ApiResponseVO fail(String msg, Object data) {
        return fail(-1, msg, data);
    }

    public static ApiResponseVO fail(int code, String msg, Object data) {
        return new ApiResponseVO(code, msg, data);
    }

    public static ApiResponseVO success(Object data) {
        return success(null, data);
    }

    public static ApiResponseVO success(String msg) {
        return success(msg, null);
    }

    public static ApiResponseVO success(String msg, Object data) {
        return success(0, msg, data);
    }

    public static ApiResponseVO success(int code, String msg, Object data) {
        return new ApiResponseVO(code, msg, data);
    }

}
