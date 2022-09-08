package cn.tedu;

import java.sql.*;
import java.util.Scanner;

/**
 * @author Freg
 * @time 2022/9/6  10:04
 *
 * 小实验：实现登录 并解决SQL注入的漏洞
 */
public class Demo07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = scanner.nextLine();
        System.out.println("请输入密码");
        String password = scanner.nextLine();
        try (Connection connection = DBUtils.getConnection()) {
            /*
            这种写法无法防御SQL注入
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT count(*) FROM user WHERE username ='"+username+"' AND password='"+password+"'");
             */

//            通过PreparedStatement对象解决SQL注入的问题
//            实例化时就进行了SQL语句的预编译  锁定语句的格式
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT COUNT(*) FROM user WHERE username=? and password=?");
//            把？替换成用户名和密码 1代表第一个问号
            preparedStatement.setString(1,username);
            preparedStatement.setString(2,password);
//            执行sql语句
            ResultSet resultSet = preparedStatement.executeQuery();
//            游标向下移动指向返回的数据
            resultSet.next();
//            去除查询到的数量,1代表查询第一列的数据
            int count = resultSet.getInt(1);
            if (count>0){
                System.out.println("登陆成功");
            } else {
                System.out.println("用户名或密码错误");
            }
        } catch (SQLException throwables) {
            System.out.println("用户名已存在");
        }
    }
}
