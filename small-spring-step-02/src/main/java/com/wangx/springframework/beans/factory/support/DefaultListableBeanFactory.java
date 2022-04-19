package com.wangx.springframework.beans.factory.support;

import com.wangx.springframework.beans.BeansException;
import com.wangx.springframework.beans.factory.config.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * 1，DefaultListableBeanFactory在Spring源码中也是以恶非常核心的类， 在我们目前的实现中也是逐步贴近于源码， 与源码类名保持一致
 * 2，DefaultListableBeanFactory继承了AbstractAutowireCapableBeanFactory类，也就具备了接口BeanFactory和AbstractBeanFactory
 * 等一连串的功能实现。所以有时候你会看到一些类的强转，调用某些方法，也是因为你强转的类的实现接口或继承了某些类。
 * 3，初次之类这个类还实现了接口BeanDefinitionRegistry中的registerBeanDefinition(String beanName, BeanDefinition beanDefinition)
 * 方法， 当然你还会看到一个getBeanDefinition的实现，这个方法我们文中提到过他是抽象类AbstractBeanFactory中定义的抽象方法。
 * 现在注册Bean定义和获取Bean定义都可以同时使用了，感觉这个套路很深。
 * 接口定义了注册，抽象类定义了获取， 最后都集中在DefaultListableBeanFactory中的beanDefinitionMap里面了
 */
public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements BeanDefinitionRegistry{

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>(0);

    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    @Override
    protected BeanDefinition getBeanDefinition(String beanName) throws BeansException {
        BeanDefinition beanDefinition = this.beanDefinitionMap.get(beanName);
        if (null == beanDefinition) {
            throw new BeansException("No bean named '" + beanName + "' is defined");
        }
        return beanDefinition;
     }


}
