package ThreadHigher.AQS;

import java.util.concurrent.locks.Lock;

public class AQSTest {
    public static int m = 0;
    public static Lock lock = new MLock();

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            threads[i]=new Thread(()->{
                try {
                    lock.lock();
                    for (int i1 = 0; i1 < 100; i1++) {
                        m++;
                    }
                } finally {
                    lock.unlock();
                }
            });
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println(m);
    }
}
