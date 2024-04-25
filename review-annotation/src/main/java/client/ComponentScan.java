package client;

import annotation.Component;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ComponentScan {
    public static void main(String[] args) {

        Map<String, Object> beanMap = new HashMap<>();

        // 目前只知道一个包的名字，扫描这个包下所有的类，当这个类上有@Component注解的时候，实例化该对象，然后放到Map集合中
        String packageName = "bean";
        // 开始写扫描程序
        // .这个正则表达式代表任意字符。这里的"."必须是一个普通的"."字符，不能是正则表达式中的"."
        // 在正则表达式中怎么表示一个普通的"."字符呢？使用\.正则表达式代表一个普通的.字符
        String packagePath = packageName.replaceAll("\\.", "/");
        // System.out.println(packagePath);

        URL url = ClassLoader.getSystemClassLoader().getResource(packagePath);
        String path = url.getPath();
        // System.out.println(path);

        // 获取一个绝对路径下的所有文件
        File file = new File(path);
        File[] files = file.listFiles();
        if (files != null) {
            Arrays.stream(files).forEach(f -> {
                // System.out.println(f.getName());
                String className = packageName + "." + f.getName().split("\\.")[0];
                // System.out.println(className);

                // 通过反射机制解析注解
                Class<?> aClass = null;
                try {
                    aClass = Class.forName(className);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // 判断类上是否有这个注解
                if (aClass != null && aClass.isAnnotationPresent(Component.class)) {
                    // 获取注解
                    Component annotation = aClass.getAnnotation(Component.class);
                    String id = annotation.value();
                    // 有这个注解的都要创建对象
                    try {
                        Object object = aClass.newInstance();
                        beanMap.put(id,object);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        System.out.println(beanMap);
    }
}
