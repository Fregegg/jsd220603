package com.example.boot011.Controller;

import com.example.boot011.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Freg
 * @time 2022/9/6  16:37
 */
@Controller
public class ParamController {
    public String  p2(HttpServletRequest request){
        String username = request.getParameter("username");
        return username;
    }

    public String p3(String name,String password){
        return name+":"+password;

    }

    @RequestMapping("/p1")
    @ResponseBody
    public String p1(User user){
        return user.toString();
    }
}
