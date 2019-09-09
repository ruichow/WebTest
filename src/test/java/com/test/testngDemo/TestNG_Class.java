package com.test.testngDemo;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author 关河九州
 * @version 1.0
 * @date 2019/9/9 0009 20:46
 */
public class TestNG_Class {
    @BeforeClass
    public void setUp(){
        System.out.println("启动测试的前提条件准备，一般放这个方法中");
    }
    @AfterClass
    public void tearDown(){
        System.out.println("测试运行结束后的步骤，一般是恢复环境到测试开始之前的状态");
    }
    @Test
    public void test1(){
        System.out.println("Hello");
    }
}
