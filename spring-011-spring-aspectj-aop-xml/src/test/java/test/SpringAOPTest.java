package test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.UserService;

public class SpringAOPTest {
    @Test
    public void testXml(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = applicationContext.getBean("userService", UserService.class);
        userService.logout();
    }
}
