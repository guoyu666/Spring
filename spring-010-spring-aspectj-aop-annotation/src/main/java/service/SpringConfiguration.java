package service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration  // 代替spring.xml文件
@ComponentScan("service")   // 组件扫描
@EnableAspectJAutoProxy(proxyTargetClass = true)    // 启用aspectj的自动代理机制
public class SpringConfiguration {
}
