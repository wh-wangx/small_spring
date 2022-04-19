package com.wangx.springframework.beans.factory.support;

import com.wangx.springframework.beans.BeansException;
import com.wangx.springframework.beans.factory.BeanFactory;
import com.wangx.springframework.beans.factory.config.BeanDefinition;

public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {


    @Override
    public Object getBean(String beanName) throws BeansException {
        return doGetBean(beanName, null);
    }

    @Override
    public Object getBean(String beanName, Object... args) throws BeansException {
        return doGetBean(beanName, args);
    }

    protected <T> T doGetBean(String beanName, final Object[] args) throws BeansException {
        Object bean = this.getSingletonBean(beanName);
        if (bean != null) {
            return (T) bean;
        }

        BeanDefinition beanDefinition = this.getBeanDefinition(beanName);
        return (T) this.createBean(beanName, beanDefinition, args);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException;
}
