package com.baidu.langshiquan.anno.dao.impl;

import com.baidu.langshiquan.anno.dao.AccountDao;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2017/10/3.
 */
@Repository
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {
    private final String IN_MONEY_SQL = "update account set money = money - ? where name = ?";
    private final String OUT_MONEY_SQL = "update account set money = money + ? where name = ?";

    public void inMoney(String in, Double money) {
        this.getJdbcTemplate().update(IN_MONEY_SQL, money, in);
    }

    public void outMoney(String out, Double money) {
        this.getJdbcTemplate().update(OUT_MONEY_SQL, money, out);
    }
}
