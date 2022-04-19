package com.wangx.springframework.beans.factory.support;

import com.wangx.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * 在 DefaultSingletonBeanRegistry 中主要实现 getSingleton 方法
 * 同时实现了一个受保护的 registrySingletonBean 方法，这个方法可以被继承此类的其他类调用。包括：
 * AbstractBeanFactory 以及继承的 DefaultListableBeanFactory 调用。
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletons = new HashMap<String, Object>(0);

    @Override
    public Object getSingletonBean(String beanName) {
        return singletons.get(beanName);
    }

    protected void addSingleton(String beanName, Object singletonObject) {
        singletons.put(beanName, singletonObject);
    }
}
