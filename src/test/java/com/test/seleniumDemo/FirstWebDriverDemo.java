package com.test.seleniumDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @Author 关河九州
 * @Date 2019/9/5 0005 23:57
 * @Version 1.0
 */
public class FirstWebDriverDemo {
    public static void main(String[] args) {
        String baseUrl;
        //加载Firefox浏览器的驱动程序，第二个参数是驱动路径
        System.setProperty("webDriver.firefox.marionette", "D:\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        baseUrl="https://www.baidu.com/";
        //打开搜狗首页
        driver.get(baseUrl+"/");
        //在搜索框中输入：光荣之路自动化测试
        driver.findElement(By.id("kw")).sendKeys("光荣之路自动化测试");
        //点击搜索按钮
        driver.findElement(By.id("su")).click();

        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        //关闭浏览器
        driver.close();
    }
}
