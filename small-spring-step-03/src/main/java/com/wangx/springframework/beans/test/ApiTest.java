package com.wangx.springframework.beans.test;

import com.wangx.springframework.beans.BeansException;
import com.wangx.springframework.beans.factory.config.BeanDefinition;
import com.wangx.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.wangx.springframework.beans.service.UserService;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

public class ApiTest {

    public static void main(String[] args) throws Exception {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 3. 注入bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 4.获取bean
        UserService userService = (UserService) beanFactory.getBean("userService", "小傅哥");
        userService.queryUserInfo();
    }

}
