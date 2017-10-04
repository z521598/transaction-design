package com.baidu.langshiquan.anno.service.impl;

import com.baidu.langshiquan.anno.dao.AccountDao;
import com.baidu.langshiquan.anno.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/10/3.
 */
// 转账场景
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;

    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT, readOnly = false,
            rollbackFor = RuntimeException.class, noRollbackFor = ArithmeticException.class)
    public void transfer(final String in, final String out, final Double money) {

        accountDao.inMoney(in, money);
        // 模拟异常
        int i = 5 / 0;
        accountDao.outMoney(out, money);

    }
}
