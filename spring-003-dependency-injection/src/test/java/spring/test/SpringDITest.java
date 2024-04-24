package spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.bean.*;
import spring.jdbc.MyDataSource;
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

    @Test
    public void testCascade(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("cascade.xml");
        Student studentBean = applicationContext.getBean("studentBean", Student.class);
        Clazz clazzBean = applicationContext.getBean("clazzBean", Clazz.class);
        System.out.println(studentBean);
        System.out.println(clazzBean);
    }

    @Test
    public void testArray(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-array.xml");
        QianDaYe yuQian = applicationContext.getBean("yuQian", QianDaYe.class);
        System.out.println(yuQian);
    }

    @Test
    public void testCollection(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-collection.xml");
        Person personBean = applicationContext.getBean("personBean", Person.class);
        System.out.println(personBean);
    }

    @Test
    public void testNull(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("set-di.xml");
        Cat catBean = applicationContext.getBean("catBean", Cat.class);
        System.out.println(catBean);
    }

    @Test
    public void testP(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-p.xml");
        Dog dogBean = applicationContext.getBean("dogBean", Dog.class);
        System.out.println(dogBean);
    }

    @Test
    public void testAutoWire(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-autowire.xml");
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        orderService.generate();
    }

    @Test
    public void testAutoWire2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-autowire.xml");
        CustomerService cs = applicationContext.getBean("cs", CustomerService.class);
        cs.save();
    }

    @Test
    public void testProperties(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-properties.xml");
        MyDataSource ds = applicationContext.getBean("ds", MyDataSource.class);
        System.out.println(ds);
    }
}
