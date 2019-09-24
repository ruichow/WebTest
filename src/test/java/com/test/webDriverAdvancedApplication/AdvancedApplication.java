package com.test.webDriverAdvancedApplication;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

/**
 * @author：关河九州
 * @date：2019/9/24 15:17
 * @version：1.0
 */
public class AdvancedApplication {
    WebDriver driver = new FirefoxDriver();
    String url = "http://www.sogou.com";
    String url1 = "http://v.sogou.com";


    @BeforeClass
    public void beforeClass() {
        //加载Firefox浏览器驱动程序，第二个参数是驱动路径
        System.setProperty("webDriver.firefox.driver", "D:\\geckodriver.exe");
        driver.get(url1);
    }


    @Test(priority = 1) //web页面的滚动条
    //priority=1表示测试用例以第一优先级运行
    public void scrollingToBottomofAPage(){
        //使用JavaScript的scrollTo函数和document.body.scrollHeight参数将页面的滚动条滑动到页面最下方
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight)");
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    @Test(priority = 2)
    public void scrollingByCoordinatesofAPage(){
        //使用JavaScript的scrollTo函数，使用0和800的横纵坐标参数
        //将页面滚动条纵向下滑800个像素
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,800)");
        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }




    @AfterClass
    public void afterClass() {
        //关闭浏览器
        driver.quit();
    }


}
