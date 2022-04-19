package com.wangx.springframework.beans.factory.support;

import com.wangx.springframework.beans.BeansException;
import com.wangx.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * 1， 在实例化接口instantiate方法中添加必要的入参信息， 包括 如下所示
 * 2， Constructor里面包含一些必要的类信息， 有这个参数的目的就是为了拿到符合入参信息相对应的构造函数
 * 3， args就是具体的入参信息， 最终在实例化的时候用到
 */
public interface InstantiationStrategy {

    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor conctor, Object[] args) throws BeansException;

}
