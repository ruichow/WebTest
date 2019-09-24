package com.test.webDriverAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * @author 关河九州
 * @version 1.0
 * @date 2019/9/23 0023 21:31
 */
public class EventOperations3 {
    WebDriver driver = new FirefoxDriver();
    String url = "http://www.sogou.com";
    String url1 = "https://kyfw.12306.cn/otn/regist/init";

    @BeforeClass
    public void beforeClass() {
        //加载Firefox浏览器驱动程序，第二个参数是驱动路径
        System.setProperty("webDriver.firefox.driver", "D:\\geckodriver.exe");
    }


    @Test  //隐式等待---设置了默认等待时间后这个隐式等待会在WebDriver对象实例的整个生命周期起作用
    public void testImplictWait(){
        driver.get(url);
        /*
        使用implictlyWait方法设定查找页面元素的最大等待时间，调用findElement方法时，
        没有立刻找到定位元素，程序会每间隔一段时间就尝试判断页面的DOM中是否出现被查找元素，
        若超过设定的等待时间依旧没有找到，则抛出NoSuchElementException
         */
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try{
            //查找搜狗首页的输入框对象
            WebElement searchInputBox=driver.findElement(By.id("query"));
            //查找搜狗首页的搜索按钮
            WebElement searchButton=driver.findElement(By.id("stb"));
            //在输入框中输入字符
            searchInputBox.sendKeys("输入框元素被成功找到");
            //单击搜索按钮
            searchButton.click();
        }catch (NoSuchElementException e){//如果没有找到元素抛出NoSuchElementException异常
            //使用fail方法，在找不到元素的时候，让测试用例执行失败
            Assert.fail("没有找到搜索的输入框");
            //打印错误的堆栈信息
            e.printStackTrace();
        }
    }

    @Test //显式等待
    /*
    显式等待比隐式等待更节约测试脚本的执行时间，尽量使用显式等待判断页面元素是否存在
    使用ExpectedCoditions类中自带的方法可以进行显式等待的判断
    等待条件                                    WebDriver方法
    页面元素是否在页面上可用(enabled)和可被单击      elementToBeClickable(By locator)
    页面元素处于被选中状态                         elementToBeSelected(WebElement element)
    页面元素在页面中存在                           presenceOfElementLocated(By locator)
    在页面元素是否包含特定的文本                    textToBePresentInElement(By locator)
    页面元素值                                  textToBePresentInElementValue(Bylocator.java.lang.String.text)
    标题(title)                                titleContains(java.lang.String.title)

    只有满足显式等待的条件要求，测试代码才会继续向后执行后续的测试逻辑。当显式等待条件未被满足时，在设置的最大
    显式等待时间阈值内，会停在当前代码位置进行等待，直到设定的条件被满足才能继续执行后续的测试逻辑。如果超过设定
    的最大显式等待时间阈值，测试程序会抛出异常，测试用例被认为执行失败
     */
    public void testExplictWait(){
        driver.get(url1);
        //声明一个webDriverWait对象，设定触发条件的最长等待时间为10秒
        WebDriverWait wait=new WebDriverWait(driver,10);
        //调用ExpectedCoditions的titleContains方法判断页面属性是否包含“铁路”
        wait.until(ExpectedConditions.titleContains("铁路"));
        System.out.println("网页标题出现了铁路关键字");
        //获得页面下拉列表中“中国居民身份证”选项对象
        WebElement select=driver.findElement(By.id("idTypeCode_second"));
        //调用ExpectedCoditions的elementToBeSelected方法判断中国居民身份证是否处于选中状态
        wait.until(ExpectedConditions.elementToBeSelected(select));
        System.out.println("下拉列表的选项中国居民身份证目前处于选中状态");
    }

    @Test  //自定义的显示等待
    public void testExplicitWait(){
        driver.get(url);
        driver.findElement(By.id("query")).sendKeys("今天");
        try {
            //显式等待判断是否可以从页面获取文字输入框对象，如果可以获取则执行后续测试逻辑
            WebElement textInputBox=(new WebDriverWait(driver,10))
                    .until(new ExpectedCondition<WebElement>() {
                        @Override
                        public WebElement apply(WebDriver d){
                            return d.findElement(By.id("query"));
                        }
                    });
            //断言获取的页面输入框中是否包含“今年”关键字
            Assert.assertEquals("今天",textInputBox.getAttribute("value"));



        }catch (NoSuchElementException e){
            //如果显式等待的条件未被满足，则使用fail函数将此测试用例设定为执行失败状态
            Assert.fail("页面上的输入框元素未找到");
            e.printStackTrace();
        }
    }



    @AfterClass
    public void afterClass() {
        //关闭浏览器
        driver.quit();
    }
}
