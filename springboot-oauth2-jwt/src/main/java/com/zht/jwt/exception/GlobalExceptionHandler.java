package com.zht.jwt.exception;

import com.zht.jwt.vo.ApiResponseVO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ApiResponseVO exception() {
        return ApiResponseVO.fail("服务器异常，请联系管理员！");
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseBody
    public ApiResponseVO userNotFoundException() {
        return ApiResponseVO.fail("用户未发现！");
    }

}
