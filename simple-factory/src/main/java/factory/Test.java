package factory;
// 这是客户端程序
public class Test {
    public static void main(String[] args) {
        // 对于我客户端来说，坦克的生产细节，我不需要关心，我只需要向工厂索要即可
        // 简单工场模式达到了什么呢？职责分离，客户端不需要关心产品的生产细节
        // 客户端只负责消费，工厂类负责生产，一个负责生产，一个负责消费
        Weapon tank = WeaponFactory.get("TANK");
        tank.attack();

        Weapon dagger = WeaponFactory.get("DAGGER");
        dagger.attack();
    }
}
