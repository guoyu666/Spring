package service;

import org.springframework.stereotype.Service;

// 目标对象
@Service("orderService")
public class OrderService {
    // 目标方法
    // 生成订单的业务方法
    public void generate(){
        System.out.println("正在生成订单...");
    }

    // 目标方法
    // 取消订单的业务方法
    public void cancel(){
        System.out.println("订单已经取消...");
    }
}
