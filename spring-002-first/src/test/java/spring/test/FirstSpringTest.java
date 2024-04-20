package spring.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FirstSpringTest {
    private static final Logger log = LoggerFactory.getLogger(FirstSpringTest.class);

    @Test
    public void testFirstSpringCode(){
        // 第一步：获取spring容器对象
        // ApplicationContext翻译为：应用上下文，其实就是Spring容器
        // ApplicationContext是一个接口
        // ApplicationContext接口下有很多实现类，其中有一个实现类叫做：ClassPathXmlApplicationContext
        // ClassPathXmlApplicationContext是专门从类路径中加载spring配置文件的一个上下文对象
        // 这行代码只要执行：就相当于启动了Spring容器，解析spring.xml文件，并且实例化所有的bean对象，放到spring容器中
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        // 第二步：根据bean的id从Spring容器中获取这个对象
        Object userBean = applicationContext.getBean("userBean");
        System.out.println(userBean);

        Date nowTime = (Date) applicationContext.getBean("nowTime");
        String strNowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(nowTime);
        System.out.println(strNowTime);
    }

    @Test
    public void testCode(){
        // 注意：不是在调用getBean()方法的时候创建对象，执行以下代码的时候，就会实例化对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        // 你自己怎么去使用log4j2记录日志信息呢？
        // 第一步：创建日志记录器对象
        // 获取FirstSpringTest类的日志记录器对象，也就是说只要是FirstSpringTest类中的代码执行记录日志的话，就输出相关的日志信息
        Logger logger = LoggerFactory.getLogger(FirstSpringTest.class);

        // 第二步：记录日志，根据不同的级别来输出日志
        logger.info("我是一条消息！");
        logger.debug("我是一条调试信息");
        logger.error("我会一条错误的信息");
    }
}
