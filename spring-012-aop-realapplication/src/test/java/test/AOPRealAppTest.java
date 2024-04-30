package test;

import biz.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.AccountService;
import service.OrderService;

public class AOPRealAppTest {
    // 编程式事务解决方案
    @Test
    public void testTransaction(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
        accountService.transfer();
        accountService.withdraw();

        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        orderService.cancel();
        orderService.generate();
    }

    @Test
    public void testSecurityLog(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.saveUser();
    }
}
