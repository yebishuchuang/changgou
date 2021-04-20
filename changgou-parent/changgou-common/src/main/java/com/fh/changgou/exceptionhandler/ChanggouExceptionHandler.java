package com.fh.changgou.exceptionhandler;

import com.fh.changgou.entity.Result;
import com.fh.changgou.entity.StatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局统一的异常处理类
 */
@ControllerAdvice
public class ChanggouExceptionHandler {

    @ExceptionHandler(value =Exception.class)
	@ResponseBody
	public Result exceptionHandler(Exception e){
       	return new Result(false, StatusCode.ERROR, e.getMessage());
    }
}