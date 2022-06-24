package com.sparsearray.IOStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class DemoInputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\idea\\DataStructures\\b.txt");
//        int read() 读取文件中的一个字节并返回，读取到文件的末尾返回-1
       int read = fis.read();
        System.out.println(read);
        int read2 = fis.read();
        System.out.println(read2);
        int read3 = fis.read();
        System.out.println(read3);
        read3 = fis.read();
        System.out.println(read3);
        read3 = fis.read();
        System.out.println(read3);
        read3 = fis.read();
        System.out.println(read3);

/*        int len;
        while ((len =fis.read()) !=-1){
            System.out.println(len);
        }
        fis.close();*/


        //一次读取多个
/*
        byte[] bytes =new byte[2];
        int len =fis.read(bytes); //int read(byte[] b) 从输入流中读取一定数量的字节，并将其存储在缓冲区数组b中
        System.out.println(new String(bytes));
        System.out.println(len);
//        System.out.println(Arrays.toString(bytes));

        len =fis.read(bytes);
        System.out.println(new String(bytes));
        System.out.println(len);

        len =fis.read(bytes);
        System.out.println(new String(bytes));
        System.out.println(len);

        len =fis.read(bytes);
        System.out.println(new String(bytes));
        System.out.println(len);*/

    }
}
