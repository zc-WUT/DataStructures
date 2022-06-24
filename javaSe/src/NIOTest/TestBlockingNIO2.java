package NIOTest;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;
import java.util.Iterator;

public class TestBlockingNIO2 {
    @Test
    public void client() throws IOException {
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("192.168.1.3", 8080));
        FileChannel inChannel = FileChannel.open(Paths.get("3.jpg"), StandardOpenOption.READ);

        ByteBuffer buf = ByteBuffer.allocate(1024);

        while (inChannel.read(buf) != -1) {
            buf.flip();
            socketChannel.write(buf);
            buf.clear();
        }

        socketChannel.shutdownOutput();

        //接收反馈
        int len;
        while ((len = socketChannel.read(buf)) != -1) {
            buf.flip();
            System.out.println(new String(buf.array(), 0, len));
            buf.clear();
        }

        inChannel.close();
        socketChannel.close();
    }

    @Test
    public void sever() throws IOException {
        ServerSocketChannel open = ServerSocketChannel.open();
        FileChannel fileChannel = FileChannel.open(Paths.get("4.jpg"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        open.bind(new InetSocketAddress(8080));
        SocketChannel accept = open.accept();
        ByteBuffer buf = ByteBuffer.allocate(1024);
        while (accept.read(buf) != -1) {
            buf.flip();
            fileChannel.write(buf);
            buf.clear();
        }

        //发送反馈
        buf.put("服务端数据接收成功".getBytes());
        buf.flip();
        accept.write(buf);

        accept.close();
        open.close();
        fileChannel.close();
    }

    @Test
    public void send() throws IOException {
        DatagramChannel dc = DatagramChannel.open();
        dc.configureBlocking(false);
        ByteBuffer buf = ByteBuffer.allocate(1024);
        String message = "消息测试";
        buf.put((new Date().toString() + "    " + message).getBytes());
        buf.flip();
        dc.send(buf, new InetSocketAddress("192.168.1.3", 8080));
        dc.close();
    }

    @Test
    public void receive() throws IOException {
        DatagramChannel dc = DatagramChannel.open();
        dc.configureBlocking(false);
        dc.bind(new InetSocketAddress(8080));
        Selector selector = Selector.open();
        dc.register(selector, SelectionKey.OP_READ);
        while (selector.select() > 0) {
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isReadable()) {
                    ByteBuffer buf = ByteBuffer.allocate(1024);
                    dc.receive(buf);
                    buf.flip();
                    System.out.println(new String(buf.array(), 0, buf.limit()));
                    buf.clear();
                }
            }
            iterator.remove();
        }
    }
}
