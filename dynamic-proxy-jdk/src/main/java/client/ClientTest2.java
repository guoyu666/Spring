package client;

import service.OrderService;
import service.OrderServiceImpl;
import util.ProxyUtil;

public class ClientTest2 {
    // 客户端程序
    public static void main(String[] args) {
        // 第一步：创建目标对象
        OrderService target = new OrderServiceImpl();
        /* 第二步：创建代理对象
            1.newProxyInstance翻译为：新建代理对象
            本质上：这个Proxy.newProxyInstance()方法的执行，做了两件事：
                第一件事： 在内存中动态的生成了代理类的字节码class
                第二件事： new对象了，通过内存中生成的代理类这个代码，实例化了代理对象
            2.关于newProxyInstance()方法的三个重要参数，每一个什么含义，有什么用？
                第一个参数：ClassLoader loader
                    类加载器，这个类加载器有什么用呢？
                        在内存当中生成的字节码也是class文件，要执行也得先加载到内存中。加载类就需要类加载器，所以这里需要指定类加载器
                        并且JDK要求，目标类的类加载器必须和代理类的类加载器使用同一个
                第二个参数：Class<?>[] interfaces
                    代理类和目标类要实现同一个或同一些接口
                    在内存中生成代理类的时候，这个代理类是需要你告诉它实现哪些接口的
                第三个参数：InvocationHandler h
                    InvocationHandler被翻译为：调用处理器，是一个接口
                    在调用处理器接口中编写的就是：增强代码
                    因为具体增强什么代码，JDK动态代理技术它是猜不到的，没有那么神
                    既然是接口，就需要写接口的实现类

                    可能会有疑问？
                        自己还要手写调用处理器接口的实现类，着不会类爆炸吗？
                        不会，因为这种调用处理器写一次就好
                注意：代理对象和目标对象实现的接口一样，所以可以向下转型
                OrderService orderServiceProxy = (OrderService)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new TimerInvocationHandler(target));*/

        // 上面的代码通过一个工具类的封装，就简洁了
        OrderService orderServiceProxy = (OrderService) ProxyUtil.newProxyInstance(target);

        // 第三步：调用代理对象的代理方法的时候，注册在Invocationhandler()接口中的invoke()方法会被调用
        // 注意：调用代理对象的代理方法的时候，如果你要做增强的话，目标对象的目标方法得保证执行
        orderServiceProxy.generate();
        orderServiceProxy.detail();
        orderServiceProxy.modify();

        String name = orderServiceProxy.getName();
        System.out.println(name);
    }
}
