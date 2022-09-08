package cn.tedu.boot01.controller;
import cn.tedu.boot01.entity.Emp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Freg
 * @time 2022/9/6  15:51
 */
@Controller
public class ParamController {
    @RequestMapping("/p1")
    @ResponseBody
    public String p1(HttpServletRequest request){
        String info = request.getParameter("info");
        return "接收到:"+info;
    }

    @RequestMapping("/p2")
    @ResponseBody     //Spring MVC提供的方法,只需要声明
    public String p2(String name,int age){
        return name+":"+age;
    }

    @RequestMapping("/p3")
    @ResponseBody     //将参数封装到对象中
    public String p3(Emp emp){
        return emp.toString();
    }


}
