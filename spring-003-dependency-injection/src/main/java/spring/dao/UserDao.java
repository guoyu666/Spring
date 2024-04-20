package spring.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Bean
 * @author GuoYu
 * @version 1.0
 * @className UserDao
 * @since 1.0
 */
public class UserDao {

    private static final Logger logger = LoggerFactory.getLogger("UserDao.Class");

    public void insert(){
        // 使用一下log4j日志框架
        logger.info("数据库正在保存用户信息");
    }
}
