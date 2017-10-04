package com.baidu.langshiquan.template.service.impl;

import com.baidu.langshiquan.template.dao.AccountDao;
import com.baidu.langshiquan.template.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

/**
 * Created by Administrator on 2017/10/3.
 */
// 转账场景
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;
    // 注入事务管理的模板
    @Autowired
    private TransactionTemplate transactionTemplate;

    public void transfer(final String in, final String out, final Double money) {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                accountDao.inMoney(in, money);
                // 模拟异常
                int i = 5 / 0;
                accountDao.outMoney(out, money);
            }
        });
    }
}
