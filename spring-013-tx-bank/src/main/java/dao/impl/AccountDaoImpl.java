package dao.impl;

import dao.AccountDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pojo.Account;

import javax.annotation.Resource;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {

    // Resource注解属于四种负责注入的注解之一（@Value,@Autowired,@Resource,@Qualifier），即给Bean的属性赋值
    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public Account selectByActno(String actno) {
        String sql = "select * from t_act where actno = ?";
        Account account = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Account.class), actno);
        return account;
    }

    @Override
    public int update(Account act) {
        String sql = "update t_act set balance = ? where actno = ?";
        int count = jdbcTemplate.update(sql, act.getBalance(), act.getActno());
        return count;
    }

    @Override
    public int insert(Account act) {
        String sql = "insert into t_act values(?,?)";
        return jdbcTemplate.update(sql, act.getActno(), act.getBalance());
    }
}
