package cn.tedu.boot01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Freg
 * @time 2022/9/6  17:15
 */
@Controller
public class BMIController {

    @RequestMapping("/bmi")
    @ResponseBody
    public String bmi(double weight,double height){
        double r = weight/(height*height);
        if (r<18.4){
            return "消瘦";
        } else if (r>=18.4&&r<=23.9){
            return "正常";
        } else if (r>23.9&&r<=27.9){
            return "超重";
        } else {
            return "肥胖";
        }
    }
}
