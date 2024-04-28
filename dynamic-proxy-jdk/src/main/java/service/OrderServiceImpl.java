package service;

// 目标对象
public class OrderServiceImpl implements OrderService{
    @Override
    public String getName() {
        System.out.println("getName()方法执行！！");
        return "GuoYu";
    }

    @Override
    public void generate() {    // 目标方法
        try {
            Thread.sleep(1234);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("订单已生成！");
    }

    @Override
    public void modify() {      // 目标方法
        try {
            Thread.sleep(2541);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("订单已修改！");
    }

    @Override
    public void detail() {      // 目标方法
        try {
            Thread.sleep(1010);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("请看订单详情！");
    }
}
