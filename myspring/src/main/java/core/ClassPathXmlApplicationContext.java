package core;

import org.dom4j.*;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class ClassPathXmlApplicationContext implements ApplicationContext {

    private static final Logger logger = Logger.getLogger(ClassPathXmlApplicationContext.class.getName());

    private Map<String, Object> singletonObjects = new HashMap<>();

    /**
     * 解析myspring的配置文件，然后初始化所有的Bean对象
     *
     * @param configLocation spring配置文件的路径。注意：使用ClassPathXmlApplicationContext，配置文件应当放到类路径下
     */
    public ClassPathXmlApplicationContext(String configLocation) {
        try {
            // 解析myspring.xml文件，然后实例化Bean，将Bean存放到singletonObjects集合中
            SAXReader reader = new SAXReader();
            // 获取一个输入流，指向配置文件
            InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream(configLocation);
            // 读文件
            Document document = reader.read(in);
            // 获取所有的bean标签
            List<Node> nodes = document.selectNodes("//bean");
            // 遍历bean标签
            for (Node node : nodes) {
                // System.out.println(node);
                // 向下转型的目的是使用Element接口里更加丰富的方法
                Element beanElt = (Element) node;
                // 获取id属性
                String id = beanElt.attributeValue("id");
                // 获取class属性
                String classname = beanElt.attributeValue("class");
                logger.info("beanName=" + id);
                logger.info("className=" + classname);
                // 通过反射机制创建对象 ，将其放到Map集合中，提前曝光
                try {
                    // 获取Class
                    Class<?> aClass = Class.forName(classname);
                    // 获取无参数构造方法
                    Constructor<?> defaultCon = aClass.getDeclaredConstructor();
                    // 调用无参数构造方法实例话Bean
                    Object bean = defaultCon.newInstance();
                    // 将Bean曝关，加入Map集合
                    singletonObjects.put(id, bean);
                    // 记录日志
                    logger.info(singletonObjects.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            // 再次重新把所有的bean标签遍历一次，这一次主要是给对象的属性赋值
            for (Node node : nodes) {
                Element beanElt = (Element) node;
                // 获取id
                String id = beanElt.attributeValue("id");
                // 获取classname
                String classname = beanElt.attributeValue("class");
                // 获取Class
                Class<?> aClass = Class.forName(classname);
                // 获取该bean标签下所有的属性property标签
                List<Element> properties = beanElt.elements("property");
                // 遍历所有的属性标签
                for (Element property : properties) {
                    // 获取属性名
                    String propertyName = property.attributeValue("name");
                    // 获取属性类型
                    Field field = aClass.getDeclaredField(propertyName);
                    logger.info("属性名：" + propertyName);
                    // 获取set方法名
                    String setMethodName = "set" + propertyName.toUpperCase().charAt(0) + propertyName.substring(1);
                    // 获取set方法
                    Method setMethod = aClass.getDeclaredMethod(setMethodName, field.getType());
                    // 获取具体的值
                    String value = property.attributeValue("value");
                    Object actualValue = null;  // 真值
                    String ref = property.attributeValue("ref");
                    if (value != null){
                        // 说明这个值是简单类型
                        // 调用set方法(set方法没有返回值)
                        // 我们myspring框架声明一下：我们只支持这些类型为简单类型
                        // byte short int long float double boolean char
                        // Byte Short Integer Long Float Double Boolean Character
                        // String

                        // 获取属性类型名
                        String propertyTypeSimpleName = field.getType().getSimpleName();
                        switch (propertyTypeSimpleName){
                            case "byte": case "Byte":
                                actualValue = Byte.valueOf(value);
                                break;
                            case "short": case "Short":
                                actualValue = Short.valueOf(value);
                                break;
                            case "int": case "Integer":
                                actualValue = Integer.valueOf(value);
                                break;
                            case "long": case "Long":
                                actualValue = Long.valueOf(value);
                                break;
                            case "float": case "Float":
                                actualValue = Float.valueOf(value);
                                break;
                            case "double": case "Double":
                                actualValue = Double.valueOf(value);
                                break;
                            case "boolean": case "Boolean":
                                actualValue = Boolean.valueOf(value);
                                break;
                            case "char": case "Character":
                                actualValue = value.charAt(0);
                                break;
                            case "String":
                                actualValue = value;
                                break;
                        }
                        setMethod.invoke(singletonObjects.get(id),actualValue);
                    }
                    if (ref != null){
                        // 说明这个值是非简单类型
                        // 调用set方法(set方法没有返回值)
                        setMethod.invoke(singletonObjects.get(id),singletonObjects.get(ref));
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Object getBean(String beanName) {
        return singletonObjects.get(beanName);
    }
}
