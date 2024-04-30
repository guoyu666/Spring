package service;

/**
 * 业务接口
 * 事务就是在这个接口下控制的
 */
public interface AccountService {

    /**
     * 转账的业务方法
     * @param fromActno 从这个账户转出
     * @param toActno 转入这个账户
     * @param money 转账金额
     */
    void transfer(String fromActno, String toActno, double money);
}
