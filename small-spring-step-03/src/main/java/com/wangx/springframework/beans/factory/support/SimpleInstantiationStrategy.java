package com.wangx.springframework.beans.factory.support;

import com.wangx.springframework.beans.BeansException;
import com.wangx.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 实例化方式一： JDK实例化
 * 1， 首先通过BeanDefinition获取CLass信息， 这个Class信息是在Bean定义的时候传递进去的
 * 2， 判断构造是否为空， 如果为空， 则是无构造参数实例化， 反之则是有构造参数实例化
 * 3， 有构造函数的实例化，实例化方式为：
 * clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
 * 把入参信息传递给 newInstance 进行实例化。
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy{
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor conctor, Object[] args) throws BeansException {
        Class beanClass = beanDefinition.getBeanClass();
        try {
            if (null != conctor) {
                return beanClass.getDeclaredConstructor(conctor.getParameterTypes()).newInstance(args);
            }else {
                return beanClass.getDeclaredConstructor().newInstance();
            }
        }catch (Exception e) {
            throw new BeansException("Failed to instantiate [" + beanClass.getName() + "]", e);
        }

    }
}
