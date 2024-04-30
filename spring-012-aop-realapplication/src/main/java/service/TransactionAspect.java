package service;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TransactionAspect {
    @Around("execution(* service..*(..))")
    public void aroundAdvice(ProceedingJoinPoint JoinPoint){
        try {
            // 前环绕
            System.out.println("开启事务...");
            // 执行目标
            JoinPoint.proceed();
            // 后环绕
            System.out.println("提交事务...");
        } catch (Throwable e) {
            System.out.println("回滚事务...");
            e.printStackTrace();
        }
    }
}
