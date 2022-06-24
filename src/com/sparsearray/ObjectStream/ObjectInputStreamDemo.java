package com.sparsearray.ObjectStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputStreamDemo {
    /**
     * 特有的成员方法
     *      Object readObject() 从ObjectInputStream读取对象
     *
     * 使用步骤：
     *      1.创建ObjectInputStream对象，构造方法中传递字节输入流
     *      2.使用ObjectInputStream对象中的readObject方法读取保存对象的文件
     *      3.释放资源
     *      4.使用读取出来的对象
     * static 关键字：静态关键字
     *      静态优先于非静态加载到内存中（静态优先于对象进入到内存中）
     *      被static修饰的成员变量不能被序列化的，序列化的都是对象
     *
     * transient 关键字：瞬态关键字
     *      修饰的成员变量，不能被序列化
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois =new ObjectInputStream(new FileInputStream("D:\\idea\\DataStructures\\src\\com\\sparsearray\\Person.txt"));
        Object object = ois.readObject();
        ois.close();
        System.out.println(object);
        Person p =(Person)object;
        System.out.println(p.getName()+p.getAge());
    }

}
