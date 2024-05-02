package service.impl;

import dao.AccountDao;
import org.springframework.stereotype.Service;
import pojo.Account;
import service.AccountService;

import javax.annotation.Resource;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Resource(name = "accountDao")
    private AccountDao accountDao;

    // 控制事务，因为在这个方法中要完成所有的转账业务
    @Override
    public void transfer(String fromActno, String toActno, double money) {

        // 第一步：开启事务

        // 第二步：执行核心业务逻辑
        // 查询账户余额是否充足
        Account fromAct = accountDao.selectByActno(fromActno);
        if (fromAct.getBalance() < money){
            throw new RuntimeException("账户余额不足！");
        }

        // 余额充足，开始转账
        Account toAct = accountDao.selectByActno(toActno);

        // 将内存中的两个对象余额先修改
        fromAct.setBalance(fromAct.getBalance() - money);
        toAct.setBalance(toAct.getBalance() + money);

        // 数据库更新
        int count = accountDao.update(fromAct);
        count += accountDao.update(toAct);

        if (count != 2){
            throw new RuntimeException("转账失败，请联系银行！");
        }

        // 第三步：如果执行过程中，没有异常，提交事务
        // 第四步：如果执行业务过程中有异常，回滚事务
    }

}