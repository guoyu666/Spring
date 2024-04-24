package test;

import bean.Husband;
import bean.Wife;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CircularDependencyTest {
    @Test
    public void testCD() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        Husband husbandBean = applicationContext.getBean("husbandBean", Husband.class);
        System.out.println(husbandBean);

        Wife wifeBean = applicationContext.getBean("wifeBean", Wife.class);
        System.out.println(wifeBean);
    }

    @Test
    public void testCD2(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring2.xml");
        bean2.Husband h = applicationContext.getBean("h", bean2.Husband.class);
        System.out.println(h);

        bean2.Wife w = applicationContext.getBean("w", bean2.Wife.class);
        System.out.println(w);
    }
}
