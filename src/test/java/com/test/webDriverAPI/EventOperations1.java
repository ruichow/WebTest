package com.test.webDriverAPI;



import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


import java.io.File;
import java.io.IOException;


/**
 * @author：关河九州
 * @date：2019/9/19 17:20
 * @version：1.0
 */
public class EventOperations1 {
    WebDriver driver = new FirefoxDriver();
    String url = "http://www.sogou.com";
    String url1 = "https://www.12306.cn/index/";

    @BeforeClass
    public void beforeClass() {
        //加载Firefox浏览器驱动程序，第二个参数是驱动路径
        System.setProperty("webDriver.firefox.driver", "D:\\geckodriver.exe");
    }

    @Test //模拟键盘操作
    public void clickKeys(){
        driver.get(url);
        Actions action=new Actions(driver);
        action.keyDown(Keys.CONTROL); //按下Ctrl键
        action.keyDown(Keys.SHIFT);  //按下Shift键
        action.keyDown(Keys.ALT);  //按下alt键
        action.keyUp(Keys.CONTROL);  //释放Ctrl键
        action.keyUp(Keys.SHIFT);  //释放Shift键
        action.keyUp(Keys.ALT); //释放alt键
        //模拟键盘在搜索输入框中输入大写的字符
        action.keyDown(Keys.SHIFT).sendKeys("abcdefg").perform();
    }

    @Test  //模拟鼠标右键操作
    public void rightClickMouse(){
        driver.get(url);
        //声明action对象
        Actions action=new Actions(driver);
        //调用action对象的contextClick方法，在输入框上单击鼠标右键
        action.contextClick(driver.findElement(By.id("query"))).perform();
    }



    @AfterClass
    public void afterClass() {
        //关闭浏览器
        driver.quit();
    }
}
