package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Freg
 * @time 2022/9/5  15:50
 */
public class Demo04 {
    public static void main(String[] args){
        try (Connection connection = DBUtils.getConnection();
        ){
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM emp");
            while(rs.next()){
                String name = rs.getString("name");
                System.out.println(name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
