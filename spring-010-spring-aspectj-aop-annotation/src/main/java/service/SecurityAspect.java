package service;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

// 安全切面
@Component("securityAspect")
@Aspect
@Order(1)
public class SecurityAspect {
    // 通知 + 切点
    @Before("execution(* service..*(..))")
    public void beforeAdvice(){
        System.out.println("前置通知：安全...");
    }
}
