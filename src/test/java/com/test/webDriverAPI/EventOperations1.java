package com.test.webDriverAPI;



import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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

    @Test //对当前浏览器窗口进行截屏
    public void captureScreenInCurrentWindow(){
        //访问搜狗首页
        driver.navigate().to(url);
        //调用getScreenshotAS方法对当前浏览器打开的页面进行截图，保存到一个file对象中
        File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            //把file对象转换为一个保存在D盘下testing目录中的名为test.png的文件
            FileUtils.copyFile(scrFile,new File("D:\\WebTest\\src\\test.png"));
        }catch (IOException e){
            e.printStackTrace();
        }

    }


    @AfterClass
    public void afterClass() {
        //关闭浏览器
        driver.quit();
    }
}
