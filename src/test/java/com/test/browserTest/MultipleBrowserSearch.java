package com.test.browserTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.reporters.jq.INavigatorPanel;

/**
 * @author：关河九州
 * @date：2019/9/12 14:38
 * @version：1.0
 */
public class MultipleBrowserSearch {
    public WebDriver driver;
    //访问地址
    String baseUrl="http://www.sogou.com";
    @Parameters("browser")//此注解定义了borwser参数，测试执行过程中此参数的具体值由xml文件中配置来传递给测试程序
    /**
     * beforeTest方法中的逻辑判断语句
     * 表示传入的Browser参数是何种浏览器的名称，根据Browser参数的值来进行webdriver浏览器对象的
     * 初始化工作，从而实现浏览器类型的动态选择
     */
    @BeforeClass
    public void beforeTest(String Browser){
        if(Browser.equalsIgnoreCase("firefox")){
            //加载Firefox浏览器驱动程序，第二个参数是驱动程序
            System.setProperty("webDriver.firefox.marionette", "D:\\geckodriver.exe");
            //打开Firefox浏览器
            driver=new FirefoxDriver();
        }else if(Browser.equalsIgnoreCase("ie")){
            //加载ie浏览器驱动程序
            System.setProperty("webdriver.ie.driver","D:\\IEDriverServer.exe");
            //打开ie浏览器
            driver=new InternetExplorerDriver();
        }else{
            //加载Chrome浏览器驱动
            System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
            //打开Chrome浏览器
            driver=new ChromeDriver();
        }
    }
    @Test
    public void testSogouSearch(){
        //打开搜狗首页
        driver.get(baseUrl+"/");
        //在输入框中输入光荣之路自动化测试
        WebElement inputBox=driver.findElement(By.id("query"));
        //断言搜索输入框是否在页面显示
        Assert.assertTrue(inputBox.isDisplayed());//inputBox.isDisplayed用来判断输入框是否显示在搜狗首页
        //输入框中输入光荣之路自动化测试
        inputBox.sendKeys("光荣之路自动化测试");
        //点击搜索按钮
        driver.findElement(By.id("stb")).click();
        //点击搜索按钮后等待3秒，让页面完成显示过程
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        //判断搜索结果中是否包含测试数据中期望的关键词
        Assert.assertTrue(driver.getPageSource().contains("光荣之路"));
    }

    @AfterClass
    public void afterTest(){
        driver.quit();//关闭浏览器
    }
}
