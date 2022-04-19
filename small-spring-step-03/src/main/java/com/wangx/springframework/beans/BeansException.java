package com.wangx.springframework.beans;

public class BeansException extends Exception {

    private String msg;

    private Object data;

    public BeansException(){}

    public BeansException(String msg) {
        this.msg = msg;
    }

    public BeansException (String msg, Object data) {
        this.msg = msg;
        this.data = data;
    }

}
