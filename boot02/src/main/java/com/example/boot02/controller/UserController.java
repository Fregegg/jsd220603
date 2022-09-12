package com.example.boot02.controller;

import com.example.boot02.Utils.DBUtils;
import com.example.boot02.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Freg
 * @time 2022/9/7  9:20
 */
@RestController  //使用RestController注解相当于每个方法上都添加了ResponseBody注解
public class UserController {

    @RequestMapping("/reg")
    public String reg(User user){
        try (Connection connection = DBUtils.getConn()) {
            String sql = "SELECT id FROM user WHERE username=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getUsername());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return "用户名已存在";
            }
            String insert_sql = "INSERT INTO user VALUES(null,?,?,?)";
            preparedStatement = connection.prepareStatement(insert_sql);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getNick());
//            执行插入
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("user = " + user);
        return "注册成功";
    }

    @RequestMapping("/login")
    public String login(User user){
        try (Connection connection = DBUtils.getConn()) {
            String sql = "SELECT password FROM user WHERE username=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getUsername());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){//true则存在
                //判断密码对不对
                if (user.getPassword().equals(resultSet.getString("password"))){

                }
                return "密码错误";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("user = " + user);
        return "用户名不存在";
    }


}
