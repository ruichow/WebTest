package com.test.testngDemo;

import org.testng.annotations.*;

/**
 * @author 关河九州
 * @version 1.0
 * @date 2019/9/9 0009 20:52
 */
public class TestNG_Parmeters {
    @Test
    @Parameters({"Browser", "Server"})//@Parameters描述了如何给一个测试方法传递参数
    public void test1(String browser, String server) {
        System.out.println("Hello World");
        System.out.println("这次启动浏览器是:" + browser + "," + "测试服务器地址是:" + server);
    }
}
