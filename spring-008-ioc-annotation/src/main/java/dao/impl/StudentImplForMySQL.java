package dao.impl;

import dao.StudentDao;
import org.springframework.stereotype.Repository;

@Repository(value = "studentImplForMySQL")
public class StudentImplForMySQL implements StudentDao {
    @Override
    public void deleteById() {
        System.out.println("MySQL数据库正在删除学生信息！！");
    }
}
