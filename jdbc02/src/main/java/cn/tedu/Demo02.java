package cn.tedu;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Freg
 * @time 2022/9/5  16:18
 */
public class Demo02 {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:10086/empdb?characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false", "root", "root"
            );
            Statement statement = connection.createStatement();
            statement.executeUpdate("INSERT INTO hero(name,age) VALUES('孙悟空',500),('猪八戒',300)");
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
