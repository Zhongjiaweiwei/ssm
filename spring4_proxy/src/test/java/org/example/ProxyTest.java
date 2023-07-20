package org.example;

import org.example.proxy.Calculator;
import org.example.proxy.CalculatorImpl;
import org.example.proxy.CalculatorStaticProxy;
import org.example.proxy.ProxyFactory;
import org.junit.Test;

public class ProxyTest {
    @Test
    public void testProxy1(){
        CalculatorStaticProxy proxy = new CalculatorStaticProxy(new CalculatorImpl());
        proxy.add(2,1);
        proxy.sub(2,1);
        proxy.mul(2,1);
        proxy.div(2,1);
    }
    @Test
    public void testProxy2(){
        ProxyFactory proxyFactory = new ProxyFactory(new CalculatorImpl());
        //向上转型
        Calculator proxy = (Calculator) proxyFactory.getProxy();
        proxy.add(2,1);
        proxy.sub(2,1);
        proxy.mul(2,1);
        proxy.div(2,1);
    }
}
