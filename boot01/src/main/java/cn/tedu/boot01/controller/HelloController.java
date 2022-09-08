package cn.tedu.boot01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author Freg
 * @time 2022/9/6  15:06
 */
@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody    //此注解的作用是通过返回值的方式给客户端响应数据
    public String hello(){
        return "请求成功";
    }

    /*
    @RequestMapping("/hello")
    public void hello(HttpServletResponse response) throws IOException {
        //设置相应类型
        response.setContentType("text/html;charset=utf-8");
        //得到输出对象
        PrintWriter writer = response.getWriter();
        //响应数据
        writer.println("请求成");
        //关闭资源
        writer.close();
    }

     */
}
