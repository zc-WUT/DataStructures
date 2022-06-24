package NIOTest;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.Iterator;

public class TestNoBlocking {
    @Test
    public void client() throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("192.168.137.1", 8080));
        socketChannel.configureBlocking(false);
        ByteBuffer buf = ByteBuffer.allocate(1024);
        buf.put(new Date().toString().getBytes());
        buf.flip();
        socketChannel.write(buf);
        buf.clear();
        socketChannel.close();
    }

    @Test
    public void sever() throws IOException {
        //获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //切换非阻塞式
        serverSocketChannel.configureBlocking(false);
        //绑定连接
        serverSocketChannel.bind(new InetSocketAddress(8080));
        //获取选择器
        Selector selector = Selector.open();
        //将通道注册得到选择器上, 并且指定“监听接收事件”
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        //选择器轮询式的获取选择器上已经准备就绪的事件
        while (selector.select()>0){//大于0说明至少有一个通道准备就绪
            //获取当前选择器中所有注册的“选择键（已就绪的监听事件）”
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                //获取准备就绪的事件
                SelectionKey sk = iterator.next();
                //判断具体是什么事件准备就绪
                if (sk.isAcceptable()){
                    //若接收就绪，获取客户端连接
                    SocketChannel accept = serverSocketChannel.accept();
                    //切换非阻塞模式
                    accept.configureBlocking(false);
                    //将通道注册到选择器上
                    accept.register(selector,SelectionKey.OP_READ);

                }else if (sk.isReadable()){
                    //获取当前选择器上“都就绪”状态的通道
                    SocketChannel socketChannel=(SocketChannel)sk.channel();
                    //读取数据
                    ByteBuffer buf = ByteBuffer.allocate(1024);
                    int len=0;
                    while ((len=socketChannel.read(buf))!=-1){
                        buf.flip();
                        System.out.println(new String(buf.array(),0,len));
                        buf.clear();
                    }
                }
                //取消选择键
                iterator.remove();
            }
        }
    }
}
