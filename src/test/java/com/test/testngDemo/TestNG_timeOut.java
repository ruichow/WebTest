package com.test.testngDemo;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * @author 关河九州
 * @version 1.0
 * @date 2019/9/9 0009 21:12
 */
public class TestNG_timeOut {
    //@Test注释的属性timeOut--判断超时
    @Test(timeOut = 3000)
    @Parameters({"name1", "age"})
    public void loginTest(String name1, int age) {
        try {
            Thread.sleep(2800);
            System.out.println("Hello,My name is " + name1 + ",and I'm " + age + " years old!");
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }
    }
}
