package NIOTest;

import org.junit.Test;

import java.nio.ByteBuffer;

public class NIOBufferTest {
    @Test
    public void test01(){
        //分配一个指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        System.out.println(buf.position());//0
        System.out.println(buf.limit());//1024
        System.out.println(buf.capacity());//1024

        //利用put方法存入数据到缓冲区中
        buf.put("abcde".getBytes());
        System.out.println(buf.position());//5
        System.out.println(buf.limit());//1024
        System.out.println(buf.capacity());//1024

        //切换到读取数据模式
        buf.flip();
        System.out.println(buf.position());//0
        System.out.println(buf.limit());//5
        System.out.println(buf.capacity());//1024

        //利用get方法读取缓冲区中数据
        byte[] bytes=new byte[buf.limit()];
        buf.get(bytes);
        System.out.println(new String(bytes,0,bytes.length));//abcde
        System.out.println(buf.position());//5
        System.out.println(buf.limit());//5
        System.out.println(buf.capacity());//1024

        //rewind方法：可重复读
        buf.rewind();
        System.out.println(buf.position());//0
        System.out.println(buf.limit());//5
        System.out.println(buf.capacity());//1024

        //清空缓冲区
        buf.clear();
        System.out.println(buf.position());//0
        System.out.println(buf.limit());//1024
        System.out.println(buf.capacity());//1024
        buf.get(bytes);
        System.out.println(new String(bytes,0,bytes.length));//abcde
    }

    @Test
    public void test02(){
        ByteBuffer buf = ByteBuffer.allocate(1024);
        buf.put("abcde".getBytes());
        buf.flip();

        byte[] bytes=new byte[buf.limit()];
        buf.get(bytes,0,2);
        System.out.println(new String(bytes,0,2));//ab
        System.out.println(buf.position());//2

        //mark标记
        buf.mark();

        buf.get(bytes,2,2);
        System.out.println(new String(bytes,2,2));//cd
        System.out.println(buf.position());//4

        //reset(),恢复到mark位置
        buf.reset();
        System.out.println(buf.position());//2

        //判断缓冲区是否还有剩余数据
        if (buf.hasRemaining()){
            //获取缓冲区中可以操作的数量
            System.out.println(buf.remaining());//3
        }
    }
}
