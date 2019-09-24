package com.test.webDriverAPI;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Set;

/**
 * @author：关河九州
 * @date：2019/9/24 11:25
 * @version：1.0
 */
public class EventOperations4 {
    WebDriver driver = new FirefoxDriver();
    String url = "http://www.sogou.com";
    String url1 = "https://kyfw.12306.cn/otn/regist/init";

    @BeforeClass
    public void beforeClass() {
        //加载Firefox浏览器驱动程序，第二个参数是驱动路径
        System.setProperty("webDriver.firefox.driver", "D:\\geckodriver.exe");
    }

    @Test  //操作浏览器的cookie
    public void testCookie() throws Exception{
        driver.get(url);
        //得到当前页面下所有的cookie，并且输出他们的所在域、name、value、有效日期、路径
        Set<Cookie> cookies=driver.manage().getCookies();
        Cookie newCookie=new Cookie("cookieName","cookieValue");
        System.out.println(String.format("Domain-> name -> value -> expiry -> path"));
        for (Cookie cookie:cookies)
            System.out.println(String.format("%s-> %s -> %s -> %s -> %s",
                    cookie.getDomain(),cookie.getName(),cookie.getValue(),
                    cookie.getExpiry(),cookie.getPath()));

        //删除cookie有3种方法
        //第一种，通过cookie的name属性
        driver.manage().deleteCookieNamed("CookieName");
        //第二种，通过cookie对象
        driver.manage().deleteCookie(newCookie);
        //第三种，全部删除
        driver.manage().deleteAllCookies();

        try {
            Thread.sleep(1500);
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    @AfterClass
    public void afterClass() {
        //关闭浏览器
        driver.quit();
    }

}
