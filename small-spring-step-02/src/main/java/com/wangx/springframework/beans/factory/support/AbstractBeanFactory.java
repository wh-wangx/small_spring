package com.wangx.springframework.beans.factory.support;

import com.wangx.springframework.beans.BeansException;
import com.wangx.springframework.beans.factory.BeanFactory;
import com.wangx.springframework.beans.factory.config.BeanDefinition;

/**
 * 1，AbstractBeanFactory首先继承了DefaultSingletonBeanRegistry， 也就是具备了使用单例注册类的方法
 * 2，接下来重要的一点是关于接口BeanFactory的实现， 在方法getBean()的实现过程中可以看到，主要是对单例bean对象的获取
 * 以及在获取不到时，需要拿到bean的定义做相应Bean的实例化操作。那么， getBean()并没有自身的取实现这些方法，而是之定义了
 * 调用过程以及提供了抽象方法，由实现此抽象类的其他类做相应的实现。
 * 3，后续继承抽象类AbstractBeanFactory的类有两个，包括：
 * AbstractAutowireCapableBeanFactory， DefaultListableBeanFactory， 这两个类分别做了相应的实现处理
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {

    @Override
    public Object getBean(String beanName) throws BeansException {
        Object singletonBean = this.getSingletonBean(beanName);
        if (null != singletonBean) {
            return singletonBean;
        }
        BeanDefinition beanDefinition = this.getBeanDefinition(beanName);
        return this.createBean(beanName, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;
}
