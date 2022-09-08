package cn.tedu.boot05.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Freg
 * @time 2022/9/8  16:52
 */
@RestController
public class UserController {
    @RequestMapping("/check")
    public String check(String username){

        return "";
    }
}
