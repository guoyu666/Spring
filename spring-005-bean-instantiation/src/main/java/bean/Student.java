package bean;

import java.util.Date;

public class Student {
    @Override
    public String toString() {
        return "Student{" +
                "birth=" + birth +
                '}';
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    // java.util.Date 在Spring当中被当作简单类型，但是简单类型的话，注入的日期字符串格式有要求
    // java.util.Date 在Spring当中也可以被当作非简单类型
    private Date birth;
}
