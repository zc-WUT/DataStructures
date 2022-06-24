package NIOTest;

import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

public class PipeTest {
    @Test
    public void sinkWrite() throws IOException {
        Pipe pipe = Pipe.open();
        Thread thread1=new Thread(()->{
            try {
                Pipe.SinkChannel sinkChannel = pipe.sink();
                ByteBuffer buf = ByteBuffer.allocate(1024);
                buf.put("管道单向数据".getBytes());
                buf.flip();
                sinkChannel.write(buf);sinkChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });
        //读取
        Thread thread2=new Thread(()->{
            try {
                Pipe.SourceChannel sourceChannel = pipe.source();
                ByteBuffer buf1 = ByteBuffer.allocate(1024);
                int len = sourceChannel.read(buf1);
                buf1.flip();
                System.out.println(new String(buf1.array(),0,len));
                sourceChannel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        thread1.start();
        thread2.start();
    }
}
