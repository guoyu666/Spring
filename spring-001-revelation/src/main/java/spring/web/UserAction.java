package spring.web;

import spring.service.UserService;
import spring.service.impl.UserServiceImpl;

/**
 * 表示层
 * @author GuoYu
 * @version 1.0
 * @className UserAction
 * @since 1.0
 */
public class UserAction {
    private UserService userService = new UserServiceImpl();

    /**
     * 删除用户信息的请求
     */
    public void deleteRequest(){
        userService.deleteUser();
    }
}
