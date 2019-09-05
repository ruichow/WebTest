package com.test.seleniumDemo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @Author 关河九州
 * @Date 2019/9/5 0005 22:31
 * @Version 1.0
 */
public class TestFirefox {
    public static void main(String[] args){
        //加载相应的驱动，第二个参数是驱动路径
        System.setProperty("webDriver.firefox.marionette","D:\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        //放大窗口
        driver.manage().window().maximize();
        //访问百度
        driver.get("https://www.baidu.com");
        //获取输入框，输入hello world
        driver.findElement(By.id("kw")).sendKeys("hello world");
        //点击搜索按钮
        driver.findElement(By.id("su")).click();
        //关闭浏览器
        driver.close();
    }
}
