package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Freg
 * @time 2022/9/5  15:06
 */
public class Demo02 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:10086/empdb?characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false","root","root"
        );
        Statement statement = connection.createStatement();
        statement.execute("DROP TABLE jdbct1");
//        int row = executeUpdate()   执行增删改相关的SQL语句.  row代表生效的行数
//        ResultSet rs = executeQuery()    执行查询相关的SQL语句 rs是结果集对象
        connection.close();
    }
}
