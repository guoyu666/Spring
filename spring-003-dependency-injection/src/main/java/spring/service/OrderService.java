package spring.service;

import spring.dao.OrderDao;

public class OrderService {

    private OrderDao orderDao;

    // 通过set注入方法给属性赋值
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    /**
     * 生成订单业务的方法
     */
    public void generate(){
        orderDao.insert();
    }
}
