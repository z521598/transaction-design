package com.baidu.langshiquan.dao;

import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/10/3.
 */
@Service
public interface AccountDao {
    void inMoney(String in,Double money);
    void outMoney(String out,Double money);

}
