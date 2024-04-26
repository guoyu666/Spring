package client;

import service.OrderService;
import service.OrderServiceImpl;
import service.OrderServiceImplSub;
import service.OrderServiceProxy;

public class Test {
    public static void main(String[] args) {
        //  OrderServiceImpl orderService = new OrderServiceImpl();
        //  orderService.generate();
        //  orderService.detail();
        //  orderService.modify();

        // OrderServiceImplSub orderServiceImplSub = new OrderServiceImplSub();
        // orderServiceImplSub.generate();
        // orderServiceImplSub.detail();
        // orderServiceImplSub.modify();

        // 创建目标对象
        OrderService target = new OrderServiceImpl();
        // 创建代理对象
        OrderService proxy = new OrderServiceProxy(target);
        // 调用代理对象的代理方法
        proxy.generate();
        proxy.modify();
        proxy.detail();
    }


}
