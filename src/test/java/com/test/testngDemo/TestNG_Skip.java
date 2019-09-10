package com.test.testngDemo;

import org.testng.annotations.Test;

/**
 * @author：关河九州
 * @date：2019/9/10 17:21
 * @version：1.0
 */
public class TestNG_Skip {
    @Test(priority = 2)
    public void test3(){
        System.out.println("3方法被调用");
    }
    @Test
    public void test1(){
        System.out.println("1方法被调用");
    }
    @Test(priority = 1,enabled = false)
    public void test2(){
        System.out.println("2方法被调用");
    }
    /**
     * 参数enabled=false忽略，test2方法被忽略执行，test1和test3方法执行
     */
}
