package com.example.s1;

/**
 * @author Freg
 * @time 2022/9/3  14:23
 */
public class demo {
}
interface Coach {
    void defend();
    void attack();
}

// 抽象类实现接口，并置空方法
abstract class AdapterCoach implements Coach {
    public void defend() {};
    public void attack() {
        System.out.println(1);
    }
}