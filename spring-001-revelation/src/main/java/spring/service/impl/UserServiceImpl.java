package spring.service.impl;

import spring.dao.UserDao;
import spring.dao.impl.UserDaoImplForMySQL;
import spring.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImplForMySQL();
    @Override
    public void deleteUser() {
        userDao.deleteById();
    }
}
