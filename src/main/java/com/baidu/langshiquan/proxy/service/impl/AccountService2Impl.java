package com.baidu.langshiquan.proxy.service.impl;

import com.baidu.langshiquan.proxy.dao.AccountDao2;
import com.baidu.langshiquan.proxy.service.AccountService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/10/3.
 */
// 转账场景
@Service
public class AccountService2Impl implements AccountService2 {

    @Autowired
    private AccountDao2 accountDao2;

    public void transfer(String in, String out, Double money) {
        accountDao2.inMoney(in, money);
        // 模拟异常
        int i = 5 / 0;
        accountDao2.outMoney(out, money);
    }
}
