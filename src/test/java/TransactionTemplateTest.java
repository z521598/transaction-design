import com.baidu.langshiquan.template.service.AccountService;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/10/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TransactionTemplateTest {

    @Autowired
    private ApplicationContext applicationContext;

    // jsr规范
    @Resource(name = "accountServiceImpl")
    private AccountService accountService;



    @Test
    public void testAccount() {
        ComboPooledDataSource c3p0 = (ComboPooledDataSource) applicationContext.getBean("dataSource");
        // 临时解决办法：由于 xml 配置了 default-autowire="byType" 导致的注入问题
        //        c3p0.setUser("root");
        //        c3p0.setPassword("mysql");
        // 最终解决方案： autowire="no" 由于spring自动装配导致的问题
        String in = "lsq";
        String out = "zdh";
        Double money = 30.0;
        accountService.transfer(in, out, money);
    }

    // debug2:用户名密码没填充进去
    @Test
    public void testConfig() {
        ComboPooledDataSource c3p0 = (ComboPooledDataSource) applicationContext.getBean("dataSource");
        System.out.println(c3p0.getPassword());
        System.out.println(c3p0.getUser());
        System.out.println(c3p0.getJdbcUrl());
        System.out.println(c3p0.getDriverClass());
    }

    @Test
    public void testTranscationTemplate() {
                String in = "lsq";
                String out = "zdh";
                Double money = 30.0;
                accountService.transfer(in, out, money);

    }


}
