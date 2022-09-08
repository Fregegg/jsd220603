package cn.tedu.boot05.controller;

import cn.tedu.boot05.entity.User;
import cn.tedu.boot05.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

}
