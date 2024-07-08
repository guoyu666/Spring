package service;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TimerMethodInterceptor implements MethodInterceptor {
    @Override
    /**
     * 第一个参数：目标对象
     * 第二个参数：目标方法
     * 第三个参数：目标方法调用时的实参
     * 第四个参数：代理方法
     *
     * 在intercept方法中，我们可以调用目标以及添加增强
     */
    public Object intercept(Object target, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // 前面增强
        long begin = System.currentTimeMillis();

        // 怎么调用目标对象的目标方法呢？
        Object returnValue = methodProxy.invokeSuper(target, objects);

        // 后面增强
        long end = System.currentTimeMillis();
        System.out.println("耗时" + (end - begin) + "ms");

        return returnValue;
    }
}
