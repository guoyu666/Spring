package service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 专门负责计时的一个调用处理器的对象
 * 在这个调用处理器当中编写计时相关的增强代码
 * 这个调用处理器只需要写一个就行了
 */
public class TimerInvocationHandler implements InvocationHandler {
    /*
        1.为什么强行要求你必须实现InvocationHandler接口？
            因为一个类实现接口就必须实现接口中的方法
            以下这个方法必须是invoke()，因为JDK在底层调用invoke()方法的程序已经提前写好了
            注意：invoke方法不是我们程序员负责调用的，是JDK负责调用的
        2.invoke方法什么时候被调用呢？
            当代理对象调用代理方法的时候，注册在InvocationHandler调用处理器当中的invoke()方法被调用
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 这个接口的目的就是
        System.out.println("invoke......");
        return null;
    }
}
