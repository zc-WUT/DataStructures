package ThreadHigher.BlockingQueueTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

public class FourApiTest {
    public static void main(String[] args) throws InterruptedException {
        test01();
    }

    public static void test01() throws InterruptedException {
        ArrayBlockingQueue blockingQueue=new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("a"));//true
        System.out.println(blockingQueue.offer("b"));//true
        System.out.println(blockingQueue.offer("c"));//true
        System.out.println(blockingQueue.offer("c",2, TimeUnit.SECONDS));//最多只阻塞2秒

        System.out.println(blockingQueue.poll());//a
        System.out.println(blockingQueue.poll());//b
        System.out.println(blockingQueue.poll());//c
        System.out.println(blockingQueue.poll(2, TimeUnit.SECONDS));//最多只阻塞2秒

    }
}
