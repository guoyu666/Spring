package client;

import service.OrderService;
import service.OrderServiceImpl;
import util.ProxyUtil;

public class ClientTest1 {
    // 客户端程序
    public static void main(String[] args) {
        // 第一步：创建目标对象
        OrderService target = new OrderServiceImpl();
        // 第二步：创建代理对象
        // 代理对象和目标对象实现的接口一样，所以可以向下转型
        // OrderService orderServiceProxy = (OrderService)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new TimerInvocationHandler(target));

        // 上面的代码通过一个工具类的封装，就简洁了
        OrderService orderServiceProxy = (OrderService) ProxyUtil.newProxyInstance(target);

        // 第三步：调用代理对象的代理方法
        // 注意：调用代理对象的代理方法的时候，如果你要做增强的话，目标对象的目标方法得保证执行
        orderServiceProxy.generate();
        orderServiceProxy.detail();
        orderServiceProxy.modify();

        String name = orderServiceProxy.getName();
        System.out.println(name);
    }
}
