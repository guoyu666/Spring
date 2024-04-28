package service;

import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.aspectj.lang.ProceedingJoinPoint;

// 切面
// 切面 = 通知 + 切点
@Component("logAspect")
@Aspect //  切面类是需要使用@Aspect注解进行标注的
@Order(2)
public class LogAspect {
    // 通知就是增强，就是具体的要编写的增强代码
    // 这里通过Advice以方法的形式出现（因为方法中可以写代码 ）
    // @Before注解标注的就是一个前置通知
    @Before("execution(* service..*(..))")
    public void beforeAdvice(){
        System.out.println("我是一个通知，我是一段代码.....");
    }

    // 后置通知
    @AfterReturning("execution(* service..*(..))")
    public void afterReturningAdvice(){
        System.out.println("后置通知");
    }

    @Around("execution(* service..*(..))")
    // 环绕通知
    public void aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        // 前面的代码
        System.out.println("前环绕");

        // 执行目标
        joinPoint.proceed();

        // 后环绕
        System.out.println("后环绕");
    }

    // 异常通知
    @AfterThrowing("execution(* service..*(..))")
    public void afterThrowingAdvice(){
        System.out.println("异常通知");
    }

    // 最终通知（finally语句块中的通知）
    @After("execution(* service..*(..))")
    public void afterAdvice(){
        System.out.println("最终通知");
    }
}
