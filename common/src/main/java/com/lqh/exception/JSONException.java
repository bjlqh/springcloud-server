package com.lqh.exception;

/**
 * @author liqihua
 * @date 2020/6/22
 */
public class JSONException extends RuntimeException {
    public JSONException() {
    }
    public JSONException(String message) {
        super(message);
    }

    public JSONException(String message, Throwable cause) {
        super(message, cause);
    }
}
