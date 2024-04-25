package dao.impl;

import dao.OrderDao;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository(value = "orderDaoImplForMySQL")
public class OrderDaoImplForMySQL implements OrderDao {
    @Override
    public void insert() {
        System.out.println("MySQL数据库正在保存订单信息！");
    }
}
