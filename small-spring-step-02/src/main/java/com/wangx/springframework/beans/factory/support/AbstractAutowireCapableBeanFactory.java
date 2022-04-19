package com.wangx.springframework.beans.factory.support;

import com.wangx.springframework.beans.BeansException;
import com.wangx.springframework.beans.factory.config.BeanDefinition;

/**
 * 在该类中实现了Bean的实例化操作newInstance()， 其实这里有一个坑， 有构造参数入参的对象怎么处理？
 * 在处理完bean对象的实例化操作后， 直接调用注册单例bean的方法，
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        this.addSingleton(beanName, bean);
        return bean;
    }
}
