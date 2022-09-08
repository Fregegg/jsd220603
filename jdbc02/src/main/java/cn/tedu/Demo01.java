package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


/**
 * @author Freg
 * @time 2022/9/5  16:15
 */
public class Demo01 {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:10086/empdb?characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false", "root", "root"
            );
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE hero(id INT PRIMARY KEY AUTO_INCREMENT,name VARCHAR(20),age INT)  ");
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
