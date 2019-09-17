package com.test.webDriverAPI;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * @author：关河九州
 * @date：2019/9/17 15:50
 * @version：1.0
 */
public class EventOperations {
    WebDriver driver = new FirefoxDriver();
    String url = "http://www.sogou.com";
    String url1 = "https://www.12306.cn/index/";

    @BeforeClass
    public void beforeClass() {
        //加载Firefox浏览器驱动程序，第二个参数是驱动路径
        System.setProperty("webDriver.firefox.driver", "D:\\geckodriver.exe");
    }

    @Test   //在输入框中清除原有的文字内容
    public void clearInputBoxText() {
        driver.navigate().to(url);
        //在输入框中输入文字
        WebElement inputBox = driver.findElement(By.id("query"));
        inputBox.sendKeys("java selenium教程");
        //清除文本框中的文字
        inputBox.clear();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test //在输入框中输入指定内容
    public void sendTextToInputBoxText() {
        driver.get(url);
        //自定义输入内容
        String inputString = "指定的输入内容";
        WebElement inputBox = driver.findElement(By.id("query"));
        //先清理文本框中的内容
        inputBox.clear();
        //将自定义变量中的内容输入到文本框中
        inputBox.sendKeys(inputString);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test  //操作单选下拉列表
    public void operateDropList() {
        driver.navigate().to(url1);
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/ul/li[3]/a[2]")).click();
        //下拉列表元素
        Select dropList = new Select(driver.findElement(By.id("cardType")));
        //isMultiple表示判断下拉列表是否允许多选，该下拉列表为单选，所以此函数返回结果为false
        Assert.assertFalse(dropList.isMultiple());
        //getFirstSelecteOption().getText()方法表示获取当前被选中的下拉列表选项文本
        //Assert.assertEquals方法断言当前选中的选项文本是否为中国居民身份证
        Assert.assertEquals("中国居民身份证", dropList.getFirstSelectedOption().getText());
        //selectByIndex方法表示表示选中下拉列表的第三个选项，0表示第一个
        dropList.selectByIndex(2);
        Assert.assertEquals("台湾居民来往大陆通行证", dropList.getFirstSelectedOption().getText());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //selectValue方法表示使用下拉列表选项的value属性值进行选中操作
        dropList.selectByValue("C");
        Assert.assertEquals("港澳居民来往内地通行证", dropList.getFirstSelectedOption().getText());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //selectByVisibleText表示通过选项的文字进行选中
        dropList.selectByVisibleText("护照");
        Assert.assertEquals("护照", dropList.getFirstSelectedOption().getText());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @AfterClass
    public void afterClass() {
        //关闭浏览器
        driver.quit();
    }

}
