package test;

import bank.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMyBatisTest {

    @Test
    public void testSpringTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        try {
            accountService.transfer("act_001","act_002",10000);
            System.out.println("转账成功...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
