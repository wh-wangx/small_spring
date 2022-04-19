package com.wangx.springframework.beans.test;

import com.wangx.springframework.beans.BeansException;
import com.wangx.springframework.beans.factory.config.BeanDefinition;
import com.wangx.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.wangx.springframework.beans.service.UserService;

public class ApiTest {

    public static void main(String[] args) throws BeansException {
        // 1, 初始化BeanFactory
        DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();

        // 2, 注册bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        defaultListableBeanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3, 第一次获取bean
        UserService userService_1 = (UserService)defaultListableBeanFactory.getBean("userService");
        userService_1.queryUserInfo();

        // 4, 第二次获取bean
        UserService userService_2 = (UserService)defaultListableBeanFactory.getBean("userService");
        userService_2.queryUserInfo();

//        System.out.println(userService_1 == userService_2);
    }

}
