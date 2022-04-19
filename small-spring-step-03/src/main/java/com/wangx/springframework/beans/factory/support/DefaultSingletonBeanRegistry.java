package com.wangx.springframework.beans.factory.support;

import com.wangx.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.Map;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonBeanMap = new HashMap<>(0);

    @Override
    public Object getSingletonBean(String beanName) {
        return singletonBeanMap.get(beanName);
    }

    protected void registrySingletonBean(String beanName, Object singletonObject) {
        singletonBeanMap.put(beanName, singletonObject);
    }
}
