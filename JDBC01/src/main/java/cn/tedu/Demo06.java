package cn.tedu;

import java.sql.*;
import java.util.Scanner;

/**
 * @author Freg
 * @time 2022/9/6  9:01
 *
 * 无法解决SQL注入问题的注册功能
 */
public class Demo06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = scanner.nextLine();

        try (Connection connection = DBUtils.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT id FROM user WHERE username='"+username+"'");
            if (rs.next()){
                System.out.println("用户名已存在");
                return;
            }
            System.out.println("注册成功");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        System.out.println("请输入密码");
        String password = scanner.nextLine();
        System.out.println("请输入昵称");
        String nickname = scanner.nextLine();
        try (Connection connection = DBUtils.getConnection()) {
            Statement statement = connection.createStatement();
            String sql = "insert into user values('"+username+"','"+password+"','"+nickname+"')";
            statement.executeUpdate(sql);
            System.out.println("注册成功");
        } catch (SQLException throwables) {
            System.out.println("用户名已存在");
        }
    }
}
