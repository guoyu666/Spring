package spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.bean.SimpleValueType;
import spring.bean.User;
import spring.service.CustomerService;
import spring.service.OrderService;
import spring.service.UserService;

import javax.xml.crypto.Data;
import java.util.Date;

public class SpringDITest {
    public static void main(String[] args) {
        System.out.println(new Date() {
        });
    }
    @Test
    public void testSetDI() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = applicationContext.getBean("userServiceBean", UserService.class);
        userService.saveUser();
    }

    @Test
    public void testConstructorDI() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        CustomerService userService = applicationContext.getBean("csBean", CustomerService.class);
        userService.save();
    }

    @Test
    public void testSetDI2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        OrderService orderService = applicationContext.getBean("orderServiceBean", OrderService.class);
        orderService.generate();

        OrderService orderService1 = applicationContext.getBean("orderServiceBean2", OrderService.class);
        orderService1.generate();
    }

    @Test
    public void testSimpleTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        User user = applicationContext.getBean("userBean", User.class);
        System.out.println(user);
    }

    @Test
    public void testSimpleType(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        SimpleValueType svt = applicationContext.getBean("svt", SimpleValueType.class);
        System.out.println(svt);
    }
}
