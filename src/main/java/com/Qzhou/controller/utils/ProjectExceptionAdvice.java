package com.Qzhou.controller.utils;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//@ControllerAdvice
@RestControllerAdvice
public class ProjectExceptionAdvice {
    //拦截所有的异常
    @ExceptionHandler(Exception.class)
    public R deException(Exception ex){
        //异常打印到控制台
        ex.printStackTrace();
        //此时直接 return 给前端
        return new R(false,"服务器故障，请稍候再试");
    }
}
