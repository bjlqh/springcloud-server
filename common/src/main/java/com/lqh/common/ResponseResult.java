package com.lqh.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author liqihua
 * @date 2020/6/4
 */
@Data
public class ResponseResult implements Serializable {

    private boolean flag;
    private Integer code;
    private String message;
    private Object data;

    public ResponseResult() {
    }

    public ResponseResult(boolean flag, Integer code, String message, Object data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResponseResult(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }
}
