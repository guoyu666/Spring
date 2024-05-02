package test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Account;
import service.AccountService;
import service.impl.IsolationService1;
import service.impl.IsolationService2;

public class SpringTxTest {

    @Test
    public void testSpringTx(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        try {
            accountService.transfer("act-001","act-002",10000);
            System.out.println("转账成功！！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testPropagation(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);

        Account act = new Account(1000.0, "act-003");
        accountService.save(act);
    }

    @Test
    public void testIsolation1(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        IsolationService1 i1 = applicationContext.getBean("i1", IsolationService1.class);
        i1.getByActno("act-004");
    }

    @Test
    public void testIsolation2(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        IsolationService2 i2 = applicationContext.getBean("i2", IsolationService2.class);
        Account act = new Account(3000.0, "act-004");
        i2.save(act);
    }

    @Test
    public void testNoXML(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext("SpringConfig.xml");
        AccountService accountService = annotationConfigApplicationContext.getBean("accountService", AccountService.class);
        try {
            accountService.transfer("act-001","acct-002",10000);
            System.out.println("转账成功....");
        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
