package com.solstice.melon.exception;

/**
 * Created by Intellij IDEA
 *
 * @Author solstice
 * @Date 2018/05/11 09:49
 * @Description 控制层异常类，用于Controller层异常的处理
 */
public class ControllerException extends RuntimeException {

    public ControllerException() {
        super();
    }

    public ControllerException(String msg) {
        super(msg);
    }

    public ControllerException(String msg,Throwable cause) {
        super(msg,cause);
    }

    public ControllerException(Throwable cause) {
        super(cause);
    }

    public ControllerException(String msg,Throwable cause,
                               boolean enableSuppression,
                               boolean writableStackTrace) {
        super(msg,cause,enableSuppression,writableStackTrace);
    }
}
