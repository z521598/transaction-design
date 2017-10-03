import com.baidu.langshiquan.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/10/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AccountTest {


    @Autowired
    private AccountService accountService;

    @Test
    public void testAccount() {
        String in = "lsq";
        String out = "zdh";
        Double money = 30.0;
        accountService.transfer(in, out, money);
    }
}
