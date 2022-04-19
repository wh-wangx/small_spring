package com.wangx.springframework;

/**
 * BeanDefinition，用于定义Bean实例化信息，现在的实现是以一个Object存放对象
 */
public class BeanDefinition {

    private Object bean;

    public BeanDefinition (Object bean){
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
