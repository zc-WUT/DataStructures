package com.sparsearray.IOStream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyAndPasImg {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("C:\\3.jpg");
        FileOutputStream fos = new FileOutputStream("D:\\3.jpg");
/*        int len;
        while ((len = fis.read()) != -1) {
            fos.write(len);
        }*/

        //使用数组缓存实现一次读取多个
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fis.read(bytes)) != -1) {
            fos.write(bytes,0,len);
        }
        fos.close();
        fis.close();
    }
}
