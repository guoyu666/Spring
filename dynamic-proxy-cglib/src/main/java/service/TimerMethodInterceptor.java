package service;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class TimerMethodInterceptor implements MethodInterceptor {
    @Override
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
