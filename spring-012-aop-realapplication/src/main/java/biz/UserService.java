package biz;

import org.springframework.stereotype.Service;

@Service("userService")
public class UserService {
    public void saveUser(){
        System.out.println("新增用户...");
    }

    public void deleteUser(){
        System.out.println("删除用户...");
    }
}
