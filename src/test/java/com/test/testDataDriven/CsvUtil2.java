package com.test.testDataDriven;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 关河九州
 * @version 1.0
 * @date 2019/9/24 0024 21:47
 */
/*
使用testng和CSV文件进行数据驱动
测试逻辑：
1、打开搜狗首页
2、从CSV文件中读取每行前两个逗号分隔的中文词作为在搜索框中输入的关键词，两个关键词中间有一个空格
3、单击搜索按钮
4、断言搜索结果中是否包含CSV文件中每行的第三个词
 */
public class CsvUtil2 {
    //读取CSV文件的静态方法，使用CSV文件的绝对文件路径作为函数参数
    public static Object[][] getTestData(String fileName) throws IOException{
        List<Object[]> records=new ArrayList<Object[]>();
        String record;
        //设定UTF-8字符集，使用带缓冲区的字符输入流BufferedReader读取文件内容
        BufferedReader file=new BufferedReader(new InputStreamReader(new
                FileInputStream(fileName),"UTF-8"));
        //忽略读取CSV文件的标题行（第一行）
        file.readLine();
        /*
        遍历读取文件中除第一行外的其他所有行内容并存储在名为“records”的ArrayList中
        每一个records中存储的对象为一个String数组
         */
        while ((record=file.readLine()) !=null){
            String fields[]=record.split(",");
            records.add(fields);
        }
        //关闭文件
        file.close();

        //定义函数返回值，即“Object[][]”
        //将存储测试数据的List转换为一个Object的二维数组
        Object[][] results=new Object[records.size()][];
        //设置二维数组每行的值，每行是一个object对象
        for (int i=0;i<records.size();i++){
            results[i]=records.get(i);
        }
        return results;

    }
}
