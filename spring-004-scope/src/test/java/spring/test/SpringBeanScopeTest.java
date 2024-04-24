package spring.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.bean.SpringBean;

public class SpringBeanScopeTest {
    @Test
    public void testBeanScope(){
        /**
         * 1.Spring默认情况下是如何管理这个Bean的：
         *      默认情况下Bean是单例的。（单例：singleton）
         *      在Spring上下文初始化的时候实例化
         *      每一次调用getBean()方法的时候，都返回那个单例的对象
         * 2.当将Bean的scope属性设置为prototype：
         *      bean是多例的
         *      soring上下文初始化的时候，并不会初始化这些prototype的Bean
         *      每一次调用getBean()方法的时候，实例化该bean对象
         *      prototype翻译为：原型
         */
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-scope.xml");
        SpringBean springBean = applicationContext.getBean("springBean", SpringBean.class);
        System.out.println(springBean);

        SpringBean springBean1 = applicationContext.getBean("springBean", SpringBean.class);
        System.out.println(springBean1);
    }
}
