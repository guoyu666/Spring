package biz;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SecurityLogAspect {

    @Pointcut("execution(* biz..save*(..))")
    public void savePointcut() {}

    @Pointcut("execution(* biz..delete*(..))")
    public void deletePointCut(){}

    @Before("savePointcut() || deletePointCut()")
    public void beforeAdvice(JoinPoint joinPoint){
        // 系统时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowTime = simpleDateFormat.format(new Date());
        // 输出日志信息
        System.out.println(nowTime + " GuoYu :" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
    }
}
