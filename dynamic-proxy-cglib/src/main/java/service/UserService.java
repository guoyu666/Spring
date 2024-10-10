package service;

/**
 * 目标类
 */
public class UserService {
    // 目标方法
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }

    // 目标方法
    public void logout(){
        System.out.println("系统正在退出...");
    }
}
