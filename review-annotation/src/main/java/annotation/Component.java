package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解
 */


// 标注注解的注解，叫做元注解。@Target注解用来修饰@Component可以出现的位置
// 使用某个注解的时候，如果注解的属性名是value的话，value可以省略
// 使用某个注解的时候，如果注解的属性值是数组，并且只有一个元素，大括号可以省略
// ElementType.TYPE表示Component注解可以出现在类上
// @Retention也是一个元注解，用来标注@Component注解最终保留在class文件当中，并且可以被反射机制读取
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
    // 定义注解的属性
    // String是属性类型
    // value是属性名
    String value();

    // 其他的属性
    // 属性类型String
    // 属性名name
    // String name();
}
