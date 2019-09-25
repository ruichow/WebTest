package com.test.testDataDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author 关河九州
 * @version 1.0
 * @date 2019/9/24 0024 22:14
 */
public class TestDataDrivenByCSVFile2 {
    public WebDriver driver;
    String baseUrl="http://www.sogou.com";
    //定义CSV测试数据文件的路径
    public static String testDataCsvFilePath="D:\\WebTest\\testData.csv";
    //使用注解Dataprovider，将数据集合命名为testData
    @DataProvider(name = "testData")
    public static Object[][] words() throws IOException{
        //调用CSV操作类
        return CsvUtil2.getTestData(testDataCsvFilePath);
    }
    @Test(dataProvider = "testData")
    public void testSearch(String searchWord1,String searchWord2,String searchResult){
        //打开搜狗首页
        driver.get(baseUrl);
        //使用CSV文件中每个数据行的前两个词汇作为搜索词
        //在两个搜索词中间增加一个空格
        driver.findElement(By.id("query")).sendKeys(searchWord1+" "+searchWord2);
        //单击搜索按钮
        driver.findElement(By.id("stb")).click();
        //使用显式等待方式确认页面已经加载完成,页面底部意见反馈及投诉显式在页面上
        (new WebDriverWait(driver,10)).until(new ExpectedCondition<Boolean>(){
            @Override
            public Boolean apply(WebDriver d){
                return d.findElement(By.id("s_footer")).getText().contains("意见反馈及投诉");
            }
        });
        //csv文件每行前两个词作为搜索词汇，断言搜索结果页面是否包含CSV文件每行中的最后一个词
        Assert.assertTrue(driver.getPageSource().contains(searchResult));

        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    @BeforeMethod
    public void beforeMethod(){
        //加载Firefox浏览器驱动程序，第二个参数是驱动路径
        System.setProperty("webDriver.firefox.driver", "D:\\geckodriver.exe");
        //打开Firefox浏览器
        driver=new FirefoxDriver();
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

}
