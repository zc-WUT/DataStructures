package com.sparsearray.ObjectStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * java.io.ObjectOutputStream extends OutputStream
 *
 * 作用：吧对象以流的方式写入到文件中保存
 *
 * 构造方法：
 *      ObjectOutPutStream(OutputStream out) 创建写入指定 OutputStream 的 ObjectOutputStream
 *      参数：
 *          OutputStream out:字节输出流
 *
 *  特优的成员方法:
 *      void writeObject(Object obj) 对指定的对象写入 ObjectOutputStream
 *
 *  使用步骤：
 *      1.创建ObjectOutputStream 对象，构造方法中传递字节输入流
 *      2.使用ObjectOutputStream 对象中的方法writeObject，吧对象写入到文件中
 */
public class ObjectOutputStreamDemo {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream("D:\\idea\\DataStructures\\src\\com\\sparsearray\\Person.txt"));
        oos.writeObject(new Person("张弛",18));
        oos.close();
    }
}
