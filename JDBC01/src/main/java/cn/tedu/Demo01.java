package cn.tedu;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Freg
 * @time 2022/9/5  14:34
 */
public class Demo01 {
    public static void main(String[] args) throws SQLException {
        /*
            1.获取数据库连接;
            2.创建执行SQL语句的对象;
            3.执行SQL语句;
            4.关闭资源
         */

//        1.获取数据库连接;
        Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:10086/empdb?characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false",
                "root","root");
//        2.创建执行SQL语句的对象;
        Statement statement = connection.createStatement();
//        3.执行SQL语句;
        statement.execute("CREATE TABLE jdbct1(name VARCHAR(20),age INT)");
//        4.关闭资源
        connection.close();
    }
}
