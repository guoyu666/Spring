package service;

import dao.StudentDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "studentService")
public class StudentService {

    @Resource(name = "studentImplForMySQL")
    private StudentDao studentDao;

    public void deleteStudent(){
        studentDao.deleteById();
    }
}
