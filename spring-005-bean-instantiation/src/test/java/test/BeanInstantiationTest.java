package test;

import bean.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanInstantiationTest {
    @Test
    public void testBeanInstantiation1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        SpringBean sb = applicationContext.getBean("sb", SpringBean.class);
        System.out.println(sb);
    }

    @Test
    public void testBeanInstantiation2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Star star = applicationContext.getBean("star", Star.class);
        System.out.println(star);
    }

    @Test
    public void testBeanInstantiation3() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Gun gun = applicationContext.getBean("gun", Gun.class);
        System.out.println(gun);
    }

    @Test
    public void testBeanInstantiation4() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Person person = applicationContext.getBean("person", Person.class);
        System.out.println(person);
    }

    @Test
    public void testDate(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Student student = applicationContext.getBean("student", Student.class);
        System.out.println(student);
    }

    @Test
    public void testDate2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Student student = applicationContext.getBean("studentBean", Student.class);
        System.out.println(student);
    }
}
