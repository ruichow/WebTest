package com.test.testngDemo;

import org.testng.annotations.Test;
//依赖测试---使用dependsOnMethods参数实现
public class TestNG_Dependent {
    //SingIn方法中使用参数dependsOnMethods={"OpenBrowser"}表示在OpenBrowser测试方法被调用后才能执行SingIn方法
    @Test(dependsOnMethods = {"OpenBrowser"})
    public void SingIn(){
        System.out.println("SingIn方法被调用");
    }
    @Test
    public void OpenBrowser(){
        System.out.println("OpenBrowser方法被调用");
    }
    //LogOut方法使用参数dependsOnMethods={"SingIn"}表示在SingIn测试方法被调用后才能执行LogOut方法
    @Test(dependsOnMethods = {"SingIn"})
    public void LogOut(){
        System.out.println("LogOut方法被调用");
    }
}
