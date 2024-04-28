package service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

// 切面
// 切面 = 通知 + 切点
@Component("logAspect")
@Aspect //  切面类是需要使用@Aspect注解进行标注的
public class LogAspect {
    // 通知就是增强，就是具体的要编写的增强代码
    // 这里通过Advice以方法的形式出现（因为方法中可以写代码 ）
    // @Before注解标注的就是一个前置通知
    @Before("execution(* service.UserService.*(..))")
    public void enhance(){
        System.out.println("我是一个通知，我是一段代码.....");
    }
}
