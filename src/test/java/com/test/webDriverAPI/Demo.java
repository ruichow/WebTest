package com.test.webDriverAPI;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * @author：关河九州
 * @date：2019/9/12 17:06
 * @version：1.0
 */
public class Demo {
    WebDriver driver = new FirefoxDriver();
    String url1 = "http://www.sogou.com";
    String url2 = "http://www.baidu.com";

    @BeforeClass
    public void beforeClass() {
        //加载Firefox浏览器驱动程序，第二个参数是驱动路径
        System.setProperty("webDriver.firefox.driver", "D:\\geckodriver.exe");
    }

    @Test
    public void assessURL() {
        driver.get(url1);
    }

    @Test
    public void visitUrl() {
        driver.navigate().to(url2);
    }

    @Test
    public void visitRecentURL() {
        driver.navigate().to(url1);
        driver.navigate().to(url2);
        driver.navigate().back();//返回到上一次访问的url1页面
        driver.navigate().forward();//再从url1跳转到url2
        driver.navigate().refresh();//刷新当前页面
    }

    @Test
    public void operateBrowser() {
        //声明一个Point对象，两个150表示浏览器的位置相对于屏幕的左上角（0,0）的横坐标距离和纵坐标距离
        Point point =new Point(150,150);
        //声明Dimension对象，两个500表示浏览器窗口的长度和宽度
        Dimension dimension=new Dimension(500,500);
        //setPositon方法表示设置浏览器在屏幕上的位置为point对象的坐标（150,150）
        driver.manage().window().setPosition(point);
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        //setSize方法表示设定浏览器窗口的大小，为（500,500）
        driver.manage().window().setSize(dimension);
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        //getPostion方法表示获取浏览器在屏幕的位置
        System.out.println(driver.manage().window().getPosition());
        //getSize方法表示获取当前浏览器窗口的大小
        System.out.println(driver.manage().window().getSize());
        //maximize方法表示将浏览器窗口最大化
        driver.manage().window().maximize();
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        driver.get(url2);
    }

    @Test
    public void getTitle(){
        //访问搜狗首页
        driver.navigate().to(url1);
        //调用driver的getTitle方法获取页面的Title属性
        String title=driver.getTitle();
        //打印从当前页面获取的Title内容
        System.out.println(title);
        //断言页面的Title是否一致
        Assert.assertEquals("搜狗搜索引擎 - 上网从搜狗开始",title);
    }

    @Test
    public void getPageSource(){
        driver.navigate().to(url2);
        //调用driver的getPageSource方法获取页面源代码
        String pageSource=driver.getPageSource();
        //打印当前页面的源代码
        System.out.println(pageSource);
        //断言页面的源代码中是否包含关键字
        Assert.assertTrue(pageSource.contains("没事看一看"));
    }

    @Test
    public void getCurrentPageUrl(){
        driver.navigate().to(url2);
        //调用driver的getCurrentUrl方法获取当前页面的url地址
        String CurrentPageUrl=driver.getCurrentUrl();
        //打印当前页面的url地址
        System.out.println(CurrentPageUrl);
        //断言当前页面的url地址是否一致
        Assert.assertEquals("https://www.baidu.com/",CurrentPageUrl);
    }

    @AfterClass
    public void afterClass() {
        //关闭浏览器
        driver.quit();
    }
}
