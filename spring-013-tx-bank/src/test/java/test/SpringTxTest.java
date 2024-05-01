package test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Account;
import service.AccountService;

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
}
