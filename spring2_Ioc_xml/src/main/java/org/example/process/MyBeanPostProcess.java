package org.example.process;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * bean的后置处理器
 */
public class MyBeanPostProcess implements BeanPostProcessor {
    //此方法在bean的生命周期初始化之前执行
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanPostProcess-->postProcessBeforeInitialization");
        return bean;
    }
    //此方法在bean的生命周期初始化之后执行
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanPostProcess-->postProcessAfterInitialization");
        return bean;
    }
}
