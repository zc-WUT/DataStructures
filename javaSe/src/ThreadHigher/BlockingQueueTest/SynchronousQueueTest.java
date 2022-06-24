package ThreadHigher.BlockingQueueTest;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class SynchronousQueueTest {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue=new SynchronousQueue<>();

        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"put 1");
                blockingQueue.put("1");
                System.out.println(Thread.currentThread().getName()+"put 2");
                blockingQueue.put("2");
                System.out.println(Thread.currentThread().getName()+"put 3");
                blockingQueue.put("3");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName()+"   "+blockingQueue.take());
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName()+"   "+blockingQueue.take());
                Thread.sleep(3000);
                System.out.println(Thread.currentThread().getName()+"   "+blockingQueue.take());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

}
