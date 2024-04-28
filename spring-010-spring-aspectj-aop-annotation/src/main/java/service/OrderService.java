package service;

import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderService {
    // 目标方法
    public void generate(){
        System.out.println("生成订单！！");
    }
}
