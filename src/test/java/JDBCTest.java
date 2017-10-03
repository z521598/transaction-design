import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import org.junit.Test;

/**
 * Created by langshiquan on 17/10/4.
 */
public class JDBCTest {

    // debug1:jdbc配置无误
    @Test
    public void testJDBC() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/trans?useUnicode=true&amp;"
                    + "characterEncoding=utf-8", "root", "mysql");
            Statement statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
