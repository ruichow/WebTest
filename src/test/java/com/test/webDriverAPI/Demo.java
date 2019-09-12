package com.test.webDriverAPI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

/**
 * @author：关河九州
 * @date：2019/9/12 17:06
 * @version：1.0
 */
public class Demo {
    WebDriver driver= new FirefoxDriver();

    @BeforeClass
    public void beforeClass(){
        //加载Firefox浏览器驱动程序，第二个参数是驱动路径
        System.setProperty("webDriver.firefox.driver", "D:\\geckodriver.exe");
    }

    @Test
    public void assessURL(){

        driver.get("http://www.sogou.com/");
    }

    @Test
    public void visitUrl(){
        //System.setProperty("webDriver.firefox.driver", "D:\\geckodriver.exe");
        driver.navigate().to("http://www.baidu.com");
    }



    @AfterClass
    public void afterClass(){
        //关闭浏览器
        driver.quit();
    }
}
