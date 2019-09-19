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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test  //检查单选列表的选项文字是否符合期望
    public void checkSelectText(){
        driver.navigate().to(url1);
        //点击注册
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/ul/li[3]/a[2]")).click();
        //定位到下拉列表元素
        Select dropList=new Select(driver.findElement(By.id("cardType")));
        /*声明一个List对象存储下拉列表中所有出现的选项文字，并且通过泛型<String>限定List
         *对象中的存储对象类型是String，Arrays.asList表示将一个数组转换为一个List对象
         */
        List<String> expect_options= Arrays.asList((new String[]{"中国居民身份证","港澳居民来往内地通行证","台湾居民来往大陆通行证","护照"}));
        //声明一个新的List对象，用于存取从页面上获取的所有选项文字
        List<String> actual_option=new ArrayList<String>();
        //dropList.getOptions方法用于获取页面上下拉列表中的所有选项对象
        //actual_option.add方法用于将实际打开页面中的每个选项添加到actual_option列表中
        for (WebElement option:dropList.getOptions())
            actual_option.add(option.getText());
        //断言期望对象和实际对象的数组值是否完全一致
        Assert.assertEquals(expect_options.toArray(),actual_option.toArray());
    }

    @Test  //操作单选框
    public void operateRadio(){
        driver.navigate().to(url1);
        //点击注册
        driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div/ul/li[3]/a[2]")).click();
        //定位单选按钮对象-中国居民身份证
        WebElement radioOption=driver.findElement(By.xpath("//*[@id=\'idTypeCode_second\']"));
        //如果此单选按钮处于未被选中状态，调用click方法选中此单选按钮
        if (!radioOption.isSelected())
            radioOption.click();
        //断言单选按钮是否处于选中状态
        Assert.assertTrue(radioOption.isSelected());
        //查找name属性为idTypeRadio的所有单选按钮对象，并存储到一个List容器中
        List<WebElement> idTypeRadios=driver.findElements(By.name("idTypeRadio"));
        /*
        使用for循环对List容器中的每个单选按钮进行遍历，查找value属性值为H的单选按钮，如果查找到的此单选
        按钮未处于选中状态，则调用click方法进行单击选择
         */
        for (WebElement idTypeRadio:idTypeRadios){
            if (idTypeRadio.getAttribute("value").equals("H")){
                if (!idTypeRadio.isSelected())
                    idTypeRadio.click();
                //断言单选按钮是否被选中
                Assert.assertTrue(idTypeRadio.isSelected());
                //选中后退出for循环
                break;
            }
        }
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
