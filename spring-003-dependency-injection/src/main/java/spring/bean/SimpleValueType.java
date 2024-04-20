package spring.bean;

import java.util.Date;

/**
 * 测试简单类
 */
public class SimpleValueType {
    private int age;
    private Integer age2;

    private boolean flag;
    private Boolean flag2;

    private char c;
    private Character c2;

    private Season season;

    private Date birth;

    @Override
    public String toString() {
        return "SimpleValueType{" +
                "age=" + age +
                ", age2=" + age2 +
                ", flag=" + flag +
                ", flag2=" + flag2 +
                ", c=" + c +
                ", c2=" + c2 +
                ", season=" + season +
                ", birth=" + birth +
                '}';
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAge2(Integer age2) {
        this.age2 = age2;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setFlag2(Boolean flag2) {
        this.flag2 = flag2;
    }

    public void setC(char c) {
        this.c = c;
    }

    public void setC2(Character c2) {
        this.c2 = c2;
    }

    public void setSeason(Season season) {
        this.season = season;
    }
}
