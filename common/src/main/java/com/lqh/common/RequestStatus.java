package com.lqh.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author liqihua
 * @date 2020/6/4
 */
@Data
public class RequestStatus implements Serializable {

    public static final int OK = 20000;//结果成功
    public static final int ERROR = 20001;//结果失败
    public static final int LOGINERROR = 20002;//用户名或密码错误
    public static final int ACCESSERROR = 20003;//权限不足
    public static final int REMOTEERROR = 20004; //远程调用失败
    public static final int REPERROR = 20005;//重复失败
}
