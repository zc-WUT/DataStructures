package NIOTest;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

public class NIOChannelTest {
    @Test
    public void test01() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            fis = new FileInputStream("3.jpg");
            fos = new FileOutputStream("4.jpg");

            //获取通道
            inChannel = fis.getChannel();
            outChannel = fos.getChannel();
            ByteBuffer buff = ByteBuffer.allocate(1024);

            //将通道中的数据存入缓冲区
            while (inChannel.read(buff) != -1) {
                //将缓冲区中的数据写入通道
                buff.flip();//切换成读数据模式
                outChannel.write(buff);
                buff.clear();//清空缓冲区
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (outChannel != null)
                    outChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (inChannel != null)
                    inChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fis == null)
                    fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    @Test
    public void test02() throws IOException {
        FileChannel open = FileChannel.open(Paths.get("3.jpg"), StandardOpenOption.READ);
        FileChannel out = FileChannel.open(Paths.get("4.jpg"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

        //内存映射文件
        MappedByteBuffer openMap = open.map(FileChannel.MapMode.READ_ONLY, 0, open.size());
        MappedByteBuffer outMap = out.map(FileChannel.MapMode.READ_WRITE, 0, open.size());

        //直接对缓冲区进行数据的读写操作
        byte[] dst = new byte[openMap.limit()];
        openMap.get(dst);
        outMap.put(dst);

        open.close();
        out.close();
    }

    @Test
    public void test03() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("3.jpg"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("4.jpg"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

//        inChannel.transferTo(0,inChannel.size(),outChannel);
        long l = outChannel.transferFrom(inChannel, 0, inChannel.size());

        inChannel.close();
        outChannel.close();
    }

    @Test
    public void test04() throws Exception {
        RandomAccessFile raf1 = new RandomAccessFile("123.txt", "rw");

        //获取通道
        FileChannel channel1 = raf1.getChannel();

        //分配指定大小的缓冲区
        ByteBuffer buf1 = ByteBuffer.allocate(100);
        ByteBuffer buf2 = ByteBuffer.allocate(1024);

        //分散读取
        ByteBuffer[] bufs = {buf1, buf2};
        channel1.read(bufs);

        for (ByteBuffer buf : bufs) {
            buf.flip();
            System.out.println("-----------------------------");
            System.out.println(new String(buf.array(), 0, buf.limit()));
        }

        //聚集写入
        RandomAccessFile raf2 = new RandomAccessFile("124.txt", "rw");
        FileChannel channel2 = raf2.getChannel();
        channel2.write(bufs);
    }

    @Test
    public void test5() {
        SortedMap<String, Charset> stringCharsetSortedMap = Charset.availableCharsets();
        Set<Map.Entry<String, Charset>> entries = stringCharsetSortedMap.entrySet();
        entries.forEach(System.out::println);
    }

    @Test
    public void test06() throws CharacterCodingException {
        Charset gbk = Charset.forName("GBK");
        //获取编码器
        CharsetEncoder charsetEncoder = gbk.newEncoder();
        //获取解码器
        CharsetDecoder charsetDecoder = gbk.newDecoder();

        CharBuffer cbf = CharBuffer.allocate(1024);
        cbf.put("这是个测试");//put时是写状态
        cbf.flip();//cbf转为读状态
        System.out.println(cbf.position());//0

        ByteBuffer bbf = charsetEncoder.encode(cbf);//编码  只能对读状态缓冲区进行编码
        System.out.println(cbf.position());//5,说明cbf被读取了5位
        System.out.println(bbf.position());//0,说明编码得到的bbf初始为读状态
        for (int i = 0; i < 8; i++) {//
            System.out.print(bbf.get());
        }//循环结束：bbf长度为10字节，只读了8字节，于是读状态position必定为8
        System.out.println("\n----------------------");

        bbf.flip();//bbf转为写状态,解码 只能对写状态的缓冲区进行解码
        System.out.println(bbf.position()+"   "+bbf.limit());//0    8 说明bbf确实是写状态
        CharBuffer cbf2 = charsetDecoder.decode(bbf);
        System.out.println(bbf.position());//8，说明解码方法自动将bbf转换为读状态了
        System.out.println(cbf2.position());//0，解码得到的cbf2初始为读状态
        System.out.println(cbf2.toString());
    }

    @Test
    public void testt(){
        CharBuffer allocate = CharBuffer.allocate(5);
        allocate.put("一二三四");
        System.out.println(allocate.position());//4
        System.out.println(allocate.limit());//5

        allocate.flip();
        char c = allocate.get();
        System.out.println(allocate.position());//1
        System.out.println(allocate.limit());//4

        allocate.flip();
        System.out.println(allocate.position());//0
        System.out.println(allocate.limit());//1
        allocate.put("1");

        allocate.flip();
        char d = allocate.get();
        System.out.println(allocate.position());//1
        System.out.println(allocate.limit());//1
    }
}
