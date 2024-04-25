package service;

import dao.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "orderService")
public class OrderService {

    // @Autowired注解使用的时候，不需要指定任何属性，直接使用这个注解即可
    // 这个注解的作用是根据类型byType进行自动装配
    @Autowired
    private OrderDao orderDao;

    public void generate() {
        orderDao.insert();
    }
}
