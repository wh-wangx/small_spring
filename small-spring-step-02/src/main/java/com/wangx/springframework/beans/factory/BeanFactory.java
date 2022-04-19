package com.wangx.springframework.beans.factory;

import com.wangx.springframework.beans.BeansException;

public interface BeanFactory {

    Object getBean(String beanName) throws BeansException;

}
