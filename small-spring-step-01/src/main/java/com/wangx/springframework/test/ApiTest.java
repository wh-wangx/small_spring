package com.wangx.springframework.test;

import com.wangx.springframework.BeanDefinition;
import com.wangx.springframework.BeanFactory;
import com.wangx.springframework.service.UserService;

public class ApiTest {

    public static void main(String[] args) {
        BeanFactory beanFactory = new BeanFactory();

        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBean("userService", beanDefinition);

        UserService userService = (UserService)beanFactory.getBean("userService");
        userService.queryUserInfo();
    }

}
