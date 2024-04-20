package spring.service;

import spring.dao.UserDao;

/**
 * Bean
 * @author GuoYu
 * @version 1.0
 * @className UserService
 * @since 1.0
 */
public class UserService {
    private UserDao userDao;

    // 这个set方法是IDEA工具生成的，符合javabean规范
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    // set注入的话，必须提供一个set方法
    // Spring容器会调用这个set方法，来给userDao属性赋值
    public void saveUser(){
        // 保存用户信息到数据库
        userDao.insert();
    }
}
