package client;

import service.OrderService;
import service.OrderServiceImpl;
import service.TimerInvocationHandler;

import java.lang.reflect.Proxy;

public class Client {
    // 客户端程序
    public static void main(String[] args) {
        // 第一步：创建目标对象
        OrderService target = new OrderServiceImpl();
        // 第二步：创建代理对象
        // 代理对象和目标对象实现的接口一样，所以可以向下转型
        OrderService orderServiceProxy = (OrderService)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new TimerInvocationHandler());
        // 第三步：调用代理对象的代理方法
        // 注意：调用代理对象的代理方法的时候，如果你要做增强的话，目标对象的目标方法得保证执行
        orderServiceProxy.generate();
        orderServiceProxy.detail();
        orderServiceProxy.modify();
    }
}
