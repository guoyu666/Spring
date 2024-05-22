package util;

import service.TimerInvocationHandler;

import java.lang.reflect.Proxy;

public class ProxyUtil {
    /**
     * 封装一个工具方法，可以通过这个方法获取代理对象
     * @param target
     * @return
     */
    public static Object newProxyInstance(Object target){
        // 底层是调用的还是JDK的动态代理
        // 我们将来肯定是要调用“目标方法”的，但要调用目标方法的话，需要“目标对象”的存在，“目标对象”从哪里来呢？我们可以给TimerInvocationHandler提供一个构造方法，可以通过这个构造方法传过来“目标对象”
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new TimerInvocationHandler(target));

    }
}
