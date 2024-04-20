package spring.dao.impl;

import spring.dao.UserDao;

public class UserDaoImplForOracle implements UserDao {

    @Override
    public void deleteById() {
        System.out.println("Oracle数据库正在删除用户！！！");
    }
}
