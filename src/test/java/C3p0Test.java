import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * Created by langshiquan on 17/10/4.
 */
@RunWith(JUnit4.class)
public class C3p0Test {

    private final String driver = "com.mysql.jdbc.Driver";

    private final String url = "jdbc:mysql://127.0.0.1:3306/trans?useUnicode=true&amp;characterEncoding=utf-8";
    private final String username = "root";
    private final String password = "mysql";

    // debug3：测试裸c3p0获取链接，进行查询无误
    @Test
    public void testC3p0() throws Throwable {
        // 创建c3p0数据源
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(username);
        comboPooledDataSource.setPassword(password);
        System.out.println(comboPooledDataSource);
        // 获取链接
        Connection connection = comboPooledDataSource.getConnection();
        Statement statement = connection.createStatement();
        // 执行查询
        ResultSet rs = statement.executeQuery("select * from account");
        ResultSetMetaData rsmd = rs.getMetaData();
        List<String[]> arr = new LinkedList<String[]>();
        int colNum = rsmd.getColumnCount();
        while (rs.next()) {
            String[] s = new String[colNum];
            for (int i = 1; i <= colNum; i++) {
                String value = rs.getString(i);
                s[i - 1] = value;

            }
            arr.add(s);
        }
        // 打印结果
        for (String[] strings : arr) {
            for (String str : strings) {
                System.out.print(str);
                System.out.print(" ");
            }
            System.out.println();
        }

    }
}
