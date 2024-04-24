package spring.bean;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class Person {
    // 注入List集合
    private List<String> names;

    // 注入Set集合
    private Set<String> addresses;

    // 注入Map集合
    // 多个电话
    private Map<Integer,String> phones;

    private Properties properties;

    @Override
    public String toString() {
        return "Person{" +
                "names=" + names +
                ", addresses=" + addresses +
                ", phones=" + phones +
                ", properties=" + properties +
                '}';
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public void setPhones(Map<Integer, String> phones) {
        this.phones = phones;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public void setAddresses(Set<String> addresses) {
        this.addresses = addresses;
    }
}
