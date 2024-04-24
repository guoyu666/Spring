package core;

/**
 * MySpring框架应用上下文接口
 */
public interface ApplicationContext {
    /**
     * 根据bean的名称获取对应的bean对象
     * @param beanName myspring配置文件中bean标签的id
     * @return 对应的单例bean对象
     */
    Object getBean(String beanName);
}
