package com.test.testngDemo;

import org.testng.annotations.*;

/**
 * @author 关河九州
 * @version 1.0
 * @date 2019/9/9 0009 22:05
 */
public class Annotation {
    @Test
    public void testCase1(){
        System.out.println("执行测试用例1");
    }
    @Test
    public void testCase2(){
        System.out.println("执行测试用例2");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("在每个测试方法开始运行前执行");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("在所有测试方法运行结束后执行");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("在当前测试类的第一个测试方法开始调用前执行");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("在当前测试类的最后一个测试方法结束运行后执行");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("在测试类中的Test开始运行前执行");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("在测试类中的Test运行结束后执行");
    }
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("在当前测试集合中的所有测试程序开始运行前执行");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("在当前测试集合中的所有测试程序运行结束后执行");
    }
}
