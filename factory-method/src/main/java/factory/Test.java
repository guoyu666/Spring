package factory;

// 客户端程序
public class Test {
    public static void main(String[] args) {
        DaggerFactory daggerFactory = new DaggerFactory();
        Weapon dagger = daggerFactory.get();
        dagger.attack();

        GunFactory gunFactory = new GunFactory();
        Weapon gun = gunFactory.get();
        gun.attack();

    }
}
