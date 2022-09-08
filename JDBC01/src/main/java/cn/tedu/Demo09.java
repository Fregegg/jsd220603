package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * @author Freg
 * @time 2022/9/6  11:30
 *
 * 解决了SQL注入问题的注册功能
 */
public class Demo09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = scanner.nextLine();
        System.out.println("请输入密码");
        String password = scanner.nextLine();
        System.out.println("请输入昵称");
        String nickname = scanner.nextLine();
        try (Connection connection = DBUtils.getConnection()) {
            String sql = "SELECT id FROM user WHERE username=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
//            判断用户是否已经存在
            if (resultSet.next()){
                System.out.println("用户名已存在");
                return;
            }
//            idea无法辨认sql语句的二次赋值，所以需要再写一个sql语句对象
            String insert_sql="INSERT INTO user VALUES(NULL,?,?,?)";
            preparedStatement = connection.prepareStatement(insert_sql);
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,nickname);
//            执行注册
            preparedStatement.executeUpdate();
            System.out.println("注册成功");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
