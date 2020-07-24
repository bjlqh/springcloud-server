package com.lqh.pay.exception;

import com.lqh.common.RequestStatus;
import com.lqh.common.ResponseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.Serializable;

/**
 * @author liqihua
 * @date 2020/6/4
 */
@RestControllerAdvice
public class CustomExceptionHandler implements Serializable {

    @ExceptionHandler(Exception.class)
    public ResponseResult error(Exception e) {
        e.printStackTrace();
        return new ResponseResult(false, RequestStatus.ERROR, e.getMessage());
    }
}
