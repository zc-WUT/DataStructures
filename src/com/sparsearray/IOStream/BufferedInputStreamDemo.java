package com.sparsearray.IOStream;

import org.junit.Test;

import java.io.*;

public class BufferedInputStreamDemo {
    /**
     * BufferedInputStream(InputStream in)创建一个BufferedInputStream并保存其参数，即输入流，以便将来使用
     * BufferedInputStream(InputStream in , int size)创建具有指定缓冲区大小的BufferedInputStream并保存其参数
     * <p>
     * 使用步骤
     * 1.创建FileInputStream对象，构造方法中绑定要读取的数据源
     * 2.创建BufferedInputStream对象，构造方法中传递FileInputStream对象，提高FileInputStream对象的读取效率
     * 3.使用BufferedInputStream对象中的方法read，读取文件
     */

    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\idea\\DataStructures\\src\\com\\sparsearray\\BufferedOutputStream.txt");
        BufferedInputStream bis = new BufferedInputStream(fis);/*
        int len = 0;//记录每次读取到的字节
        while ((len=bis.read())!=-1){
            System.out.println(len);
        }*/

        byte[] bytes = new byte[1024];
        int len = 0; //记录每次读取的有效字节个数
        while ((len = bis.read(bytes)) != -1) {
            System.out.println(new String(bytes, 0, len));
        }
        bis.close();
    }

    @Test
    public void testCopy() throws IOException {
        long s = System.currentTimeMillis();

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("C:\\3.jpg"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("D:\\3.jpg"));

/*        int len = 0;
        while ((len = bis.read()) != -1){
            bos.write(len);
        }*/

        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }

        bos.close();
        bis.close();

        long e = System.currentTimeMillis();
        System.out.println("一个耗时" + (e - s) + "毫秒");

    }
}
