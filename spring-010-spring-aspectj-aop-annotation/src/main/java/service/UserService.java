package service;

import org.springframework.stereotype.Service;

// 目标类
@Service("userService")
public class UserService {
    // 目标方法
    public void login(){
        System.out.println("系统正在进行身份认证....");
    }
}
