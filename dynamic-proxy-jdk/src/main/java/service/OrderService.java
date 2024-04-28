package service;

/**
 * 订单业务接口
 */
public interface OrderService { //代理对象和目标对象的公共接口

    String getName();

    // 生成订单
    void generate();

    // 修改订单信息
    void modify();

    // 查看订单详情
    void detail();
}
