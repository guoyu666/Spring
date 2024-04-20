package spring.service;

import spring.dao.UserDao;
import spring.dao.VipDao;

/**
 * Bean
 * @author GuoYu
 * @version 1.0
 * @className CustomerService
 * @since 1.0
 */
public class CustomerService {
    private UserDao userDao;
    private VipDao vipDao;

    public CustomerService(UserDao userDao, VipDao vipDao) {
        this.userDao = userDao;
        this.vipDao = vipDao;
    }

    public void save(){
        userDao.insert();
        vipDao.insert();
    }
}
