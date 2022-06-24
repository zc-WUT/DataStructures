package com.sparsearray.ReaderAndWriter;

//java.io.reader:字符流，是字符（不是字节）的最高级父类，是一个抽象类

import java.io.FileReader;
import java.io.IOException;

/**
 * 成员方法
 * int read 读取单个字符并返回
 * int read(char[] c) 一次读取多个字符，将字符读入数组
 * void close 释放资源
 */
public class DemoReader01 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("c.text");
/*        int len = 0;
        while ((len = fr.read()) != -1){
            System.out.print((char)len);
        }*/

        char[] cs = new char[1024];
        int len = 0;
        while ((len = fr.read(cs)) != -1) {
            System.out.println(new String(cs,0,len));
        }
        fr.close();
    }

}
