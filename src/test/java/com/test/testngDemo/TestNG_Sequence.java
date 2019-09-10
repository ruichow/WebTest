package com.test.testngDemo;

import org.testng.annotations.Test;

//按照特定顺序执行测试用例
public class TestNG_Sequence {
    //参数priority实现按照特定顺序执行测试用例
    @Test(priority = 2)
    public void test3(){
        System.out.println("3方法被调用");
    }
    @Test(priority = 0)
    public void test1(){
        System.out.println("1方法被调用");
    }
    @Test(priority = 3)
    public void test4(){
        System.out.println("4方法被调用");
    }
    @Test(priority = 1)
    public void test2(){
        System.out.println("2方法被调用");
    }
/**
 * test1~test4方法的注解@Test后添加参数priority并分别赋值，测试中test1~test4顺序是乱的，但是
 * 从测试结果可以看出还是按照test1~test4的方法顺序执行的，这就是priority参数在testng中实现了按照
 * 特定顺序执行测试用例
 */
}
