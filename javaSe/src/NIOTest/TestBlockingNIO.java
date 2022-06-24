package NIOTest;

import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestBlockingNIO {
    @Test
    public void client() throws IOException {
        //获取通道
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("192.168.1.3", 8001));
        FileChannel inChannel=FileChannel.open(Paths.get("3.jpg"), StandardOpenOption.READ);
        //分配指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        //读取本地文件，从客户端发送到服务端
        while (inChannel.read(buf)!=-1){
            buf.flip();
            sChannel.write(buf);
            buf.clear();
        }
        inChannel.close();
        sChannel.close();
    }

    @Test
    public void server() throws IOException {
        //获取通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        FileChannel outChannel = FileChannel.open(Paths.get("4.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        //绑定连接
        ssChannel.bind(new InetSocketAddress(8001));
        //获取客户端连接的通道
        SocketChannel sChannel=ssChannel.accept();
        //分配指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        //接收客户端的数据，保存到本地
        while (sChannel.read(buf)!=-1){
            buf.flip();
            outChannel.write(buf);
            buf.clear();
        }

    }

    @Test
    public void download() throws IOException {
        URL url = new URL("https://www.baidu.com/img/flexible/logo/pc/result.png");
        ReadableByteChannel sChannel = Channels.newChannel(url.openStream());
        FileChannel outChannel = FileChannel.open(Paths.get("4.png"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        //分配指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        //读取本地文件，从客户端发送到服务端
        while (sChannel.read(buf)!=-1){
            buf.flip();
            outChannel.write(buf);
            buf.clear();
        }
        outChannel.close();
        sChannel.close();
    }
}
