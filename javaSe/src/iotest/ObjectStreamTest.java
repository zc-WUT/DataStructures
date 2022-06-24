package iotest;

import org.junit.Test;

import java.io.*;

public class ObjectStreamTest {
    @Test
    public void test01() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Object.txt"));
        oos.writeObject(new Person("涨三",18));
        oos.writeObject(new Person("李四",20));
        oos.flush();
        oos.close();
    }

    @Test
    public void test02() throws IOException, ClassNotFoundException {
        ObjectInputStream ois=new ObjectInputStream(new FileInputStream("Object.txt"));
        Object object = ois.readObject();
        System.out.println(object);
        Object object1 = ois.readObject();
        System.out.println(object1);
    }
}
