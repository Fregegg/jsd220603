package cn.tedu.boot05.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Freg
 * @time 2022/9/8  16:21
 */
@RestController
public class BMIController {
    @RequestMapping("/bmi")
    public String bmi(double w,double h){
        double r = w/(h*h);
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
