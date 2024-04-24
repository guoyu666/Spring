package spring.bean;

/**
 * 表示班级
 */
public class Clazz {
    private String name;

    @Override
    public String toString() {
        return "Clazz{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }
}
