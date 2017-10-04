import com.baidu.langshiquan.proxy.service.AccountService2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/10/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-proxy.xml")
public class ProxyTransactionTest {

    //  注入代理类
    @Resource(name = "transactionProxyFactoryBean")
    private AccountService2 accountService2;

    @Test
    public void testTranscationTemplate() {
        String in = "lsq";
        String out = "zdh";
        Double money = 30.0;
        accountService2.transfer(in, out, money);
    }
}
