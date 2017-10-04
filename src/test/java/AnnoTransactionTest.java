
import com.baidu.langshiquan.anno.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Administrator on 2017/10/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext-anno.xml")
public class AnnoTransactionTest {

    //  注入代理类
    @Autowired()
    private AccountService accountService;

    @Test
    public void testTranscationTemplate() {
        String in = "lsq";
        String out = "zdh";
        Double money = 30.0;
        accountService.transfer(in, out, money);
    }
}
