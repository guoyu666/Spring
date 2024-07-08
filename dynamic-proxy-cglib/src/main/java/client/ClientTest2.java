package client;

import net.sf.cglib.proxy.Enhancer;
import service.TimerMethodInterceptor;
import service.UserService;

/**
 * 使用cglib在内存中为UserService类生成代理类，并创建对象
 */
public class ClientTest2 {
    public static void main(String[] args) {
        // 创建字节码增强器对象
        Enhancer enhancer = new Enhancer();

        // 告诉CGLIB父类是谁，告诉CGLIB目标类是谁
        enhancer.setSuperclass(UserService.class);

        // 设置回调（等同于JDK动态代理当中的调用处理器。InvocationHandler）
        // 在CGLIB当中不是Invocation接口，是方法拦截器接口：MethodInterceptor
        enhancer.setCallback(new TimerMethodInterceptor());

        // 创建代理对象
        // 这一步会做两件事
        // 第一件事情：在内存中生成UserService类的子类，其实就是代理类的字节码
        // 第二件事情：创建代理对象
        // 父类是UserService，子类这个代理类一定是UserService
        UserService userServiceProxy = (UserService) enhancer.create();

        // 调用代理对象的代理方法
        boolean success = userServiceProxy.login("admin", "123");
        System.out.println(success ? "登录成功！" : "登录失败！");

        userServiceProxy.logout();
    }
}
