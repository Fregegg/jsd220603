import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Freg
 * @time 2022/9/5  16:24
 */
public class DBUtils {
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:10086/empdb?characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false", "root", "root"
        );
    }
}
