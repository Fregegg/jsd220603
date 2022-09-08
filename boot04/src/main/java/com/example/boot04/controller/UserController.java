package com.example.boot04.controller;

import com.example.boot04.entity.User;
import com.example.boot04.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Freg
 * @time 2022/9/8  10:58
 */
@RestController
public class UserController {
    @Autowired
    UserMapper mapper;

    @RequestMapping("/reg")
    public String reg(User user){
//        u为数据库里的对象 user为用户传过来的对象
        User u = mapper.selectByUsername(user.getUsername());
        if (u!=null){
            return "用户名已存在";
        }
        mapper.insert(user);
        return "注册成功";
    }

    @RequestMapping("/login")
    public String login(User user){
        User u = mapper.selectByUsername(user.getUsername());
        if (u!=null){//代表查到了
//            判断密码是否一致
            if (user.getPassword().equals(u.getPassword())){
                return "登陆成功";
            }
            return "密码错误";
        }
        return "用户名不存在";
    }
}
