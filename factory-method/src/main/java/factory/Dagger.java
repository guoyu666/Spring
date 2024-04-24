package factory;

// 具体产品角色
public class Dagger extends Weapon{
    @Override
    public void attack() {
        System.out.println("砍人！");
    }
}
