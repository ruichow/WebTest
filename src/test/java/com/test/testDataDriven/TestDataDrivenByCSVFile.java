package com.test.testDataDriven;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

import java.io.IOException;

/**
 * @author 关河九州
 * @version 1.0
 * @date 2019/9/24 0024 22:14
 */
public class TestDataDrivenByCSVFile {
    public WebDriver driver;
    String baseUrl="http://www.sogou.com";
    //定义CSV测试数据文件的路径
    public static String testDataCsvFilePath="D:\\WebTest\\testData.csv";
    //使用注解Dataprovider，将数据集合命名为testData
    @DataProvider(name = "testData")
    public static Object[][] words() throws IOException{
        //调用CSV操作类
        return CsvUtil.getTestData(testDataCsvFilePath);
    }

}
