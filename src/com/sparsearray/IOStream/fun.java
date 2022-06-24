package com.sparsearray.IOStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class fun {

    public static void main(String[] args) throws IOException {
//        show();

        //文件字节输入流
        FileOutputStream fos = new FileOutputStream(new File("c.text"),true);
//        fos.write(97);
//        byte[] bytes={65,66,67};//ABC
        byte[] bytes = "你好".getBytes();
        fos.write(bytes);
        fos.write("\r\n".getBytes());//windows的换行符号"\r\n"
        fos.write(bytes);
        fos.close();

    }

    /*private static void show() {
        File file =new File("D:\\QQ\\1049379728\\FileRecv");
        File[] d = file.listFiles();
        for (File c:d){

            System.out.println(c.getAbsolutePath());
        }
    }*/
}
