package test;

import bean.Student;
import bean.User;
import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleTest {
    /**
     * Spring容器只对singleton的Bean进行完整的生命周期管理
     * 如果是prototype作用域的Bean，Spring容器 只负责将该Bean初始化完毕。等客户端程序一旦取到该Bean之后，Spring容器就不再管理该对象的生命周期了
     */

    @Test
    public void testBeanLifeCycleFive() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        User user = applicationContext.getBean("user", User.class);
        System.out.println("第六步：使用Bean：" + user);
        // 注意：必须手动关闭Spring容器 ，这样Spring容器才会销毁Bean
        applicationContext.close();
    }

    @Test
    public void testRegisterBean(){
        // 自己new对象
        Student student = new Student();
        System.out.println(student);

        // 将以上自己new的这个对象纳入Spring容器来管理，半路上交给Spring来管理
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        factory.registerSingleton("studentBean",student);

        // 从Spring容器中获取
        Object studentBean = factory.getBean("studentBean");
        System.out.println(studentBean);
    }
}
