package com.baidu.langshiquan.service.impl;

import com.baidu.langshiquan.dao.AccountDao;
import com.baidu.langshiquan.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/10/3.
 */
// 转账场景
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    public void transfer(String in, String out, Double money) {
        accountDao.inMoney(in, money);
        // 模拟异常
        int i = 5 / 0;
        accountDao.outMoney(out, money);
    }
}
