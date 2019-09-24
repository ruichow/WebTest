package com.test.testDataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author 关河九州
 * @version 1.0
 * @date 2019/9/24 0024 20:48
 */

/*
数据驱动---相同的测试脚本使用不同的测试数据来执行，测试数据和测试行为实现了完全的分离，这样的测试脚本设计模式
称为数据驱动。例如测试网站的登录功能时，想验证不同的用户名和密码在网站登录时的系统影响结果，就可以使用数据驱动
模式来实现。
实施数据驱动测试的步骤如下：
1、编写测试脚本，脚本需要支持程序对象、文件或数据库读入测试数据
2、将测试脚本使用的测试数据存入程序对象、文件或数据库等外部介质中
3、运行脚本，循环调用存储在外部介质中的测试数据
4、验证所有测试结果是否符合期望

使用testng进行数据驱动
测试逻辑：
1、打开搜狗首页
2、在搜索框中输入关键词
3、单击搜索按钮
4、验证搜索结果页面是否包含搜索的关键词
 */
public class DataProviderTest {
    private static WebDriver driver;
    //@DataProvider注解将当前方法中的返回对象作为测试脚本的测试数据集，并将测试数据集命名为searchWord
    @DataProvider(name = "searchWords")
    //测试脚本自动打开三次浏览器，分别输入三组不同的词作为搜索词进行查询
    public static Object[][] words(){
        return new Object[][]{{"黄飞鸿","主演","李连杰"},{"战狼","主演","吴京"},
                {"生化危机","编剧","安德森"}};
    }

    @Test(dataProvider = "searchWords")
    /*
    public void test(String searchWord1,String searchWord2,String searchResult)测试方法中的
    三个参数分别使用searchWords测试数据集中的一维数组中的数据进行赋值，此测试方法会被调用三次，分别使用测试
    数据集中的三组数据。searchWord1和searchWord2分别作为在搜索框中输入的关键词，searchResult用来判断
    搜索结果是否包含期望的搜索关键词
     */
    public void test(String searchWord1,String searchWord2,String searchResult){
        //加载Firefox浏览器驱动程序
        System.setProperty("webDriver.firefox.driver", "D:\\geckodriver.exe");
        //打开Firefox浏览器
        driver=new FirefoxDriver();
        //设定等待时间为10秒
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //访问搜狗首页
        driver.get("http://www.sogou.com");
        //在搜索框中输入
        driver.findElement(By.id("query")).sendKeys(searchWord1+""+searchWord2);
        //单击搜索按钮
        driver.findElement(By.id("stb")).click();

        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        //判断搜索结果的页面是否包含测试数据中期望的关键词
        Assert.assertTrue(driver.getPageSource().contains(searchResult));
        //关闭浏览器
        driver.quit();
    }
}
