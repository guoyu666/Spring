package spring.bean;

import java.util.Date;

public class Dog {
    // 简单类型
    private String name;
    private int age;

    // 非简单类型
    private Date birth;

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                '}';
    }

    // p命名空间注入底层还是set注入，只不过p命名空间注入 可以让spring配置变的更加简单
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }
}
