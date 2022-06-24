package com.sparsearray.ReaderAndWriter;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/*
 * properties类表示了一个持久的属性集，可保存在流中或从流中加载
 * properties集合是唯一一个和IO流向结合的集合
 *   可以使用properties集合中的方法store，把集合中的临时数据，持久化写入到硬盘中存储
 *   可以使用properties集合中的方法load，把硬盘中保存的文件（键值对），读取到集合中使用
 *
 * 属性列表中每个建及其对应值都是一个字符串
 *       properties集合是一个双列集合，key和value默认都是字符串
 * */
public class DemoProperties {
    public static void main(String[] args) throws IOException {
//        show01();
//        show02();
        show03();
    }

    private static void show03() throws IOException {
        //void load(InputStream in)//字节输入流，不能读取含有中文的键值对，乱码
        //void load(Reader reader)

        Properties pro = new Properties();
        pro.load(new FileReader("D:\\idea\\DataStructures\\src\\com\\sparsearray\\prop.txt"));
        Set<String> strings = pro.stringPropertyNames();
        for (String key : strings) {
            String property = pro.getProperty(key);
            System.out.println(key + "=" + property);
        }
    }


    private static void show02() throws IOException {
        //使用properties集合中的方法store，将集合中的临时数据，持久化写入到硬盘中存储
        //void store(OutputStream out,String comments)//不能使用中文，会乱码
        //void store(Writer writer,String comments)
        //String comments 用来解释说明保存的文件是做什么用的，不能使用中文，会乱码

        Properties pro = new Properties();
        pro.setProperty("赵丽颖", "168");
        pro.setProperty("王宝强", "165");
        pro.setProperty("张弛", "180");

        FileWriter fw = new FileWriter("D:\\idea\\DataStructures\\src\\com\\sparsearray\\prop.txt");
        pro.store(fw, "save data");
        fw.close();

    }


    /*
     *使用properties集合存储数据，遍历取出properties集合中的数据
     * setProperty(String key,String value);方法，写入数据
     * stringPropertyNames();把键取出，放入Set集合方法
     * */
    private static void show01() {
        Properties pro = new Properties();
        pro.setProperty("赵丽颖", "168");
        pro.setProperty("王宝强", "165");
        pro.setProperty("张弛", "180");

        Set<String> str = pro.stringPropertyNames();

        for (String key : str) {
            String property = pro.getProperty(key);
            System.out.println(key + "=" + property);
        }
        pro.clear();
    }

}
