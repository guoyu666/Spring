package service;

import org.springframework.stereotype.Service;

// 目标对象
@Service("accountService")
public class AccountService {
    // 目标方法
    // 转账的业务方法
    public void transfer(){
        System.out.println("银行账户正在完成转账操作...");
    }

    // 目标方法
    // 取款的业务方法
    public void withdraw(){
        System.out.println("正在取款，请稍后...");
    }
}
