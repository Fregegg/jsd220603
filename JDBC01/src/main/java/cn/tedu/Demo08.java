package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author Freg
 * @time 2022/9/6  11:13
 */
public class Demo08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = scanner.nextLine();
        System.out.println("请输入密码");
        String password = scanner.nextLine();
        try(Connection connection = DBUtils.getConnection()){
            String sql = "SELECT password FROM user WHERE username=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            ResultSet resultSet =preparedStatement.executeQuery();
//            判断是否查询到了数据
            if (resultSet.next()){
//                判断密码是否一致
                if (resultSet.getString("password").equals(password)){
                    System.out.println("登陆成功");
                } else {
                    System.out.println("密码错误");
                }
            }else {
                System.out.println("用户名不存在");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
