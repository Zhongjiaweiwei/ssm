package org.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/*
代理对象有两种：
1、jdk动态代理（要求必须有接口，最终生成的代理类为com.sun.proxy，类名为$proxy2）
2、cglib动态代理(最终生成的代理类会继承目标类，并且和目标类在相同的包下)
 */
public class ProxyFactory {
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }
    public Object getProxy(){
        /*Proxy:运用反射产生代理对象
        newProxyInstance:创建代理实例
        参数:1、classLoader：加载动态生成的代理类的类加载器
        2、interfaces：目标对象实现的所有接口的class对象所组成的数组
        3、invocationHandler：设置代理对象实现目标对象方法的过程，即代理类中如何重写接口中的抽象方法*/

        //1、随便获取一个应用类加载器
        ClassLoader classLoader = this.getClass().getClassLoader();
        //2、获取所有实现的接口的数组（通过反射获取）
        Class<?>[] interfaces = target.getClass().getInterfaces();
        //3、重写目标方法（匿名内部类）
        InvocationHandler handler=new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("[动态代理][日志] "+method.getName()+"，参数："+ Arrays.toString(args));
                //proxy:表示代理对象,method:表示要执行的方法,args:表示要执行的方法的参数
                //invoke表示执行方法
                Object result = method.invoke(target, args);
                System.out.println("[动态代理][日志] "+method.getName()+"，结果："+ result);
                return result;
            }
        };
        return Proxy.newProxyInstance(classLoader,interfaces,handler);
    }
}
