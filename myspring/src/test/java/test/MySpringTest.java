package test;

import bean.UserService;
import core.ApplicationContext;
import core.ClassPathXmlApplicationContext;
import org.dom4j.DocumentException;
import org.junit.Test;

public class MySpringTest {
    @Test
    public void testMySpring() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("myspring.xml");

        Object user = applicationContext.getBean("user");
        System.out.println(user);

        UserService userService = (UserService) applicationContext.getBean("userService");
        System.out.println(userService);
        userService.save();

    }
}
