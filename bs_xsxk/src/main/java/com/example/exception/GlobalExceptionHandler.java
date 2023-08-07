package com.example.exception;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.example.common.Result;
import com.example.common.ResultCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice(basePackages="com.example.controller")
//@ControllerAdvice来声明一些全局性的东西，最常见的是结合@ExceptionHandler注解用于全局异常的处理
public class GlobalExceptionHandler {//处理捕获的异常

    private static final Log log = LogFactory.get();


    //统一异常处理@ExceptionHandler,主要用于Exception
    @ExceptionHandler(Exception.class)
//    Spring的@ExceptionHandler可以用来统一处理方法抛出的异常
    @ResponseBody//返回json串
    public Result error(HttpServletRequest request, Exception e){
        log.error("异常信息：",e);
        return Result.error();
    }

    @ExceptionHandler(CustomException.class)
    @ResponseBody//返回json串
    public Result customError(HttpServletRequest request, CustomException e){
        return Result.error(e.getCode(), e.getMsg());
    }
}
