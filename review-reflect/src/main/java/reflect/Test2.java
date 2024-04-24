package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        // 使用反射机制怎么调用方法
        // 获取类
        Class<?> clazz = Class.forName("reflect.SomeService");

        // 获取方法
        Method doSomeMethod = clazz.getDeclaredMethod("doSome", String.class, int.class);

        // 调用方法
        // 四要素：调用哪个对象，哪个方法，传什么参数，返回什么值
        // obj:哪个对象
        // doSomeMethod:哪个方法
        // “GuoYu” 250:参数
        // returnValue:返回什么值
        Object obj = clazz.newInstance();
        Object returnValue = doSomeMethod.invoke(obj, "Guoyu", 250);
        System.out.println(returnValue);
    }
}
