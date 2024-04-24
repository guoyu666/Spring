package reflect;

public class Test {
    public static void main(String[] args) {
        // 不使用反射机制调用方法
        SomeService someService = new SomeService();
        someService.doSome();

        /**
         * 分析：调用一个方法，当中含有有几个要素？四要素
         * 第一要素：调用哪个对象
         * 第二要素：调用哪个方法
         * 第三要素：调用方法的时候传什么参数
         * 第四要素 ：方法执行结束的时候返回结果
         *
         * 调用哪个对象的哪个方法，传什么参数，返回什么值
         *
         * 即使是使用反射机制调用方法，也同样需要具备这四个要素
         */
        String s = someService.doSome("GuoYu",250);
        System.out.println(s);
    }

}
