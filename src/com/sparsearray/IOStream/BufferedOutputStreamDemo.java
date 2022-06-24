package com.sparsearray.IOStream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;


//字节缓冲输出流
//BufferedOutputStream(OutputStream out)
public class BufferedOutputStreamDemo {
    /*
    * 创建FileOutputStream对象，构造方法中要绑定输出的目的地
    * 创建BufferedOutputStream对象，构造方法中传递FileOutputStream对象，提高FileOutputStream对象效率
    * 使用BufferedOutputStream对象中的方法write，把数据写入到内部缓冲区中
    * 使用BufferedOutputStream对象中的方法flush，把内存缓冲区的数据刷新到文件中
    * 释放资源
    * */

    public static void main(String[] args) throws IOException {
        FileOutputStream fos=new FileOutputStream("D:\\idea\\DataStructures\\src\\com\\sparsearray\\BufferedOutputStream.txt");
        BufferedOutputStream bos=new BufferedOutputStream(fos);
        bos.write("我把数据写入到内部缓冲区中".getBytes());
        bos.flush();
        fos.close();

    }
}
