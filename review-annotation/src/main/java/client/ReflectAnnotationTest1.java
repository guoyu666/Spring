package client;

import annotation.Component;
import bean.User;

public class ReflectAnnotationTest1 {
    public static void main(String[] args) throws ClassNotFoundException {
        // 通过反射机制怎么获取注解
        // 获取类
        Class<?> aClass = Class.forName("bean.User");
        // 判断类上面有没有这个注解
        if (aClass.isAnnotationPresent(Component.class)) {
            // 程序能够执行到这说明类上面有这个注解
            // 获取类上的注解
            Component annotation = aClass.getAnnotation(Component.class);
            // 访问注解的属性
            System.out.println(annotation.value());
        }
    }
}
