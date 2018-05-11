package com.solstice.melon.exception;

/**
 * Created by Intellij IDEA
 *
 * @Author solstice
 * @Date 2018/05/11 09:51
 * @Description 服务层异常类,用于服务层异常处理
 */
public class ServiceException extends RuntimeException{

    public ServiceException(){
        super();
    }

    public ServiceException(String msg) {
        super(msg);
    }

    public ServiceException(String msg,Throwable cause) {
        super(msg,cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String msg, Throwable cause,
                            boolean enableSuppression,
                            boolean writableStackTrace) {
        super(msg,cause,enableSuppression,writableStackTrace);
    }

}
