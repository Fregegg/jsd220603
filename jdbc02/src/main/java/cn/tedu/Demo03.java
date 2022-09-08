package cn.tedu;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Freg
 * @time 2022/9/5  16:24
 */
public class Demo03 {
    public static void main(String[] args) {
        try {
            Connection connection = DBUtils.getConnection();
            Statement statement = connection.createStatement();
            statement.executeUpdate("DELETE FROM hero WHERE name='猪八戒'");
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
