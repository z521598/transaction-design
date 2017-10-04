package com.baidu.langshiquan.template.dao;

/**
 * Created by Administrator on 2017/10/3.
 */
public interface AccountDao {
    void inMoney(String in, Double money);

    void outMoney(String out, Double money);

}
