package com.wangx.springframework.beans;

import com.wangx.springframework.beans.factory.config.BeanDefinition;

public class BeansException extends Exception {

    private String exceptionMsg;

    private Object exception;

    public BeansException() {}

    public BeansException(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

    public BeansException(String exceptionMsg, Object exception) {
        this.exceptionMsg = exceptionMsg;
        this.exception = exception;
    }

}
