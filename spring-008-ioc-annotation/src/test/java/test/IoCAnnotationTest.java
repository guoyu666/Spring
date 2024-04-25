package test;

import bean.Order;
import bean.Student;
import bean.User;
import bean.Vip;
import bean3.MyDataSource;
import bean3.Product;
import bean.OrderDao;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.OrderService;
import service.SpringConfig;
import service.StudentService;

public class IoCAnnotationTest {
    @Test
    public void testBeanComponent(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User userBean = applicationContext.getBean("userBean", User.class);
        System.out.println(userBean);

        Vip vipBean = applicationContext.getBean("vipBean", Vip.class);
        System.out.println(vipBean);

        Order orderBean = applicationContext.getBean("orderBean", Order.class);
        System.out.println(orderBean);

        Student studentBean = applicationContext.getBean("studentBean", Student.class);
        System.out.println(studentBean);

        OrderDao orderDao = applicationContext.getBean("orderDao", OrderDao.class);
        System.out.println(orderDao);
    }

    @Test
    public void testChoose(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-choose.xml");
    }

    @Test
    public void testDIByAnnotation(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-di-annotation.xml");
        MyDataSource myDataSource = applicationContext.getBean("myDataSource", MyDataSource.class);
        System.out.println(myDataSource);

        Product product = applicationContext.getBean("product", Product.class);
        System.out.println(product);
    }

    @Test
    public void AnnotationTest(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-autowired.xml");
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);
        orderService.generate();
    }

    @Test
    public void testResource(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-resource.xml");
        StudentService studentService = applicationContext.getBean("studentService", StudentService.class);
        studentService.deleteStudent();
    }

    @Test
    public void testNoXML(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        StudentService studentService = annotationConfigApplicationContext.getBean("studentService", StudentService.class);
        studentService.deleteStudent();
    }
}
