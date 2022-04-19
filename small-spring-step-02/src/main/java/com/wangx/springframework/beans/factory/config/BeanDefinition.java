package com.wangx.springframework.beans.factory.config;

/**
 * 在Bean定义的类中，把上一章节中的Object bean换成了CLass，
 * 这样就可以把Bean的实例化操作放到容器中处理了
 * Bean的实例化操作是放在初始化调用阶段传递给BeanDefinition构造函数的
 * BeanDefinition beanDefinition = new BeanDefinition(bean对象)；
 */
public class BeanDefinition {

    private Class beanClass;

    public BeanDefinition(Class beanClass) {
        this.beanClass = beanClass;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
