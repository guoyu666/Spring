package spring.client;

import spring.web.UserAction;

/**
 * @author GuoYu
 * @version 1.0
 * @className Test
 * @since 1.0
 */
public class Test {
    public static void main(String[] args) {
        UserAction userAction = new UserAction();
        userAction.deleteRequest();
    }
}
