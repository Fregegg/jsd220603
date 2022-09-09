package cn.tedu.boot05.controller;

import cn.tedu.boot05.entity.User;
import cn.tedu.boot05.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Freg
 * @time 2022/9/8  16:52
 */
@RestController
public class UserController {
    @Autowired
    UserMapper mapper;

    @RequestMapping("/check")
    public int check(String username){
        User u = mapper.selectByUsername(username);
        if (u!=null) {//在数据库中找到了相同的用户名
            return 1;
        }

        return 0;
    }

    @RequestMapping("/reg")
    public int reg(@RequestBody User user){
        User u = mapper.selectByUsername(user.getUsername());
        if (u!=null){
            return 2;//用户名已存在
        }
        mapper.insert(user);
        System.out.println("user = " + user);
        return 1;
    }

    @RequestMapping("/login")
    public int login(@RequestBody User user){
        User u = mapper.selectByUsername(user.getUsername());
        if (u!=null){
            if (u.getPassword().equals(user.getPassword())){
                return 1;
            }
            return 3;
        }
        return 2;//用户名不存在或密码错误
    }

}
