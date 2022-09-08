package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Freg
 * @time 2022/9/5  16:29
 */
public class Demo05 {
    public static void main(String[] args) {
        try {
            Connection connection = DBUtils.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM hero");
            while (rs.next()){
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println(name+": "+age);
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
