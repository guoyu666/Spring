package dao;

import pojo.Account;

// 专门负责账户信息的CRUD操作
// DAO中只执行SQL语句，没有任何业务逻辑
// 也就是说DAO不和业务挂钩
public interface AccountDao {

    // 根据账号查询账户信息
    Account selectByActno(String actno);

    // 更新账户信息
    int update(Account act);

    // 保存账户信息
    int insert(Account act);
}
