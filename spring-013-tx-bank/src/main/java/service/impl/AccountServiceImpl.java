package service.impl;

import dao.AccountDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pojo.Account;
import service.AccountService;

import javax.annotation.Resource;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Resource(name = "accountDao")
    private AccountDao accountDao;

    // 控制事务，因为在这个方法中要完成所有的转账业务
    @Override
    @Transactional(propagation = Propagation.REQUIRED)
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

    @Transactional(propagation = Propagation.REQUIRED)
    public void withdraw(){

    }

    @Resource(name = "accountService2")
    private AccountService accountService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Account act) {
        // 这里调用dao的insert方法
        accountDao.insert(act); // 这里保存act-003账户


        // 创建账户对象
        Account act2 = new Account(1000.0,"act-004");
        accountService.save(act2);  // 保存act-004账户
    }

}