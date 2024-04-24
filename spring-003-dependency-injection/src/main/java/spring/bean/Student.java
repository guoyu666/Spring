package spring.bean;

/**
 * 表示学生
 */
public class Student {
    private String name;

    // 学生属于哪个班级
    private Clazz clazz;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", clazz=" + clazz +
                '}';
    }

    // 使用级联属性赋值，需要使用这个get方法
    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public void setName(String name) {
        this.name = name;
    }
}
