package cn.tedu;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Freg
 * @time 2022/9/5  16:27
 */
public class Demo04 {
    public static void main(String[] args) {
        try {
            Connection connection = DBUtils.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE hero SET name='齐天大圣' WHERE name='孙悟空' ");
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
