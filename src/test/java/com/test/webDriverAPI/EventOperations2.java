package com.test.webDriverAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author：关河九州
 * @date：2019/9/23 15:42
 * @version：1.0
 */
public class EventOperations2 {
    WebDriver driver = new FirefoxDriver();
    String url = "http://www.sogou.com";

    @BeforeClass
    public void beforeClass() {
        //加载Firefox浏览器驱动程序，第二个参数是驱动路径
        System.setProperty("webDriver.firefox.driver", "D:\\geckodriver.exe");
    }

    @Test  //查看页面元素属性
    public void getWebElementAttribute(){
        driver.get(url);
        String inputString="测试工程师指定的输入内容";
        //定位搜索输入框
        WebElement input=driver.findElement(By.id("query"));
        //将自定义变量中的内容输入到文本框中
        input.sendKeys(inputString);
        //调用getAttribute方法，获取页面搜索框的value属性值（即搜索输入框的文字内容）
        String inputText=input.getAttribute("value");
        Assert.assertEquals(inputText,"测试工程师指定的输入内容");
    }

    @Test  //获取页面元素的css属性值
    public void getWebElementCssValue(){
        driver.get(url);
        //页面输入框定位
        WebElement input=driver.findElement(By.id("query"));
        //用getCssValue方法，获取搜索框的宽度
        String inputWidth=input.getCssValue("width");
        System.out.println(inputWidth);
        //断言页面宽度是否是499px
        Assert.assertEquals("499px",inputWidth);
    }



    @AfterClass
    public void afterClass() {
        //关闭浏览器
        driver.quit();
    }
}
