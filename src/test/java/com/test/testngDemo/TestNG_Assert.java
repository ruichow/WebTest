package com.test.testngDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * @author：关河九州
 * @date：2019/9/12 10:14
 * @version：1.0
 */
public class TestNG_Assert {
    WebDriver driver= new FirefoxDriver();
    String baseUrl="http://www.sogou.com";
    @Test
    public void testSogouSearch(){
        //打开搜狗首页
        driver.get(baseUrl+"/");
        //在搜索框中输入光荣之路自动化测试
        WebElement inputBox=driver.findElement(By.id("query"));
        /**
         * 使用Assert类的assertTrue方法断言搜索输入框是否在页面显示
         * isDisplayed方法根据页面元素的显示状态返回判断值，在页面显示则返回true
         * 不显示则返回false
         */
        Assert.assertTrue(inputBox.isDisplayed());
        inputBox.sendKeys("光荣之路自动化测试");
        //单机搜索按钮
        driver.findElement(By.id("stb")).click();

        try{
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    @BeforeMethod
    public void beforeMethod(){
        //加载Firefox浏览器驱动程序，第二个参数是驱动路径
        System.setProperty("webDriver.firefox.marionette", "D:\\geckodriver.exe");
    }
    @AfterMethod
    public void afterMethod(){
        //关闭浏览器
        driver.quit();
    }
}
