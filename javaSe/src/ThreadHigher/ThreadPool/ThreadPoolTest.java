package ThreadHigher.ThreadPool;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {
        long l1 = System.currentTimeMillis();
        final Random random = new Random();
        final List<Integer> list = new ArrayList<>();
        //ExecutorService executorService = Executors.newSingleThreadExecutor();//最慢
        //ExecutorService executorService = Executors.newFixedThreadPool(10);//慢
        ExecutorService executorService = Executors.newCachedThreadPool();//最快

        for (int i = 0; i < 100000; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            });
        }
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.DAYS);
        System.out.println("时间" + (System.currentTimeMillis() - l1));//35ms
        System.out.println("大小" + list.size());//100000
    }

    @Test
    public void test() {
        long l1 = System.currentTimeMillis();
        final Random random = new Random();
        final List<Integer> list = new ArrayList<>();

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20,
                0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10));
        for (int i = 0; i < 1000000; i++) {

            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    list.add(random.nextInt());

                }
            });
        }
        threadPoolExecutor.shutdown();
        System.out.println("时间" + (System.currentTimeMillis() - l1));//35ms
        System.out.println("大小" + list.size());//100000
    }
}
