package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        String className ="reflect.User";
        String propertyName = "age";

        // 通过反射机制调用setAge(int)方法
        // 获取类
        Class<?> clazz = Class.forName("reflect.User");

        // 获取方法名
        String setMethodName = "set" + propertyName.toUpperCase().charAt(0) + propertyName.substring(1);

        // 根据属性名获取属性类型
        Field field = clazz.getDeclaredField(propertyName);

        // 获取方法
        Method setMethod = clazz.getDeclaredMethod(setMethodName, field.getType());

        // 准备对象
        Object object = clazz.newInstance();

        // 调用方法
        setMethod.invoke(object,30);

        System.out.println(object);
    }

}
