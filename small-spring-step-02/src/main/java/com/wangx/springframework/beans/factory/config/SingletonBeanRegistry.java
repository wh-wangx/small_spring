package com.wangx.springframework.beans.factory.config;

/**
 * 单例注册接口定义和实现
 */
public interface SingletonBeanRegistry {

    Object getSingletonBean(String beanName);
}
