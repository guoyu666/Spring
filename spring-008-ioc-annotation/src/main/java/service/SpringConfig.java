package service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 编写一个类，代替Spring框架的配置文件
 */

@Configuration
@ComponentScan({"dao", "service"})
public class SpringConfig {

}
