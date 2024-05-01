package service.impl;

import dao.AccountDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pojo.Account;
import service.AccountService;

import javax.annotation.Resource;

@Service("accountService2")
public class AccountServiceImpl2 implements AccountService {

    @Resource(name = "accountDao")
    private AccountDao accountDao;

    @Override
    public void transfer(String fromActno, String toActno, double money) {

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void save(Account act) {
        
        accountDao.insert(act);
    }
}
