package Thread.gaoji;

import java.util.concurrent.*;

public class TestPool {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        创建服务，创建线程池
        ExecutorService service= Executors.newFixedThreadPool(10);

        service.submit(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.shutdown();

    }
}

class MyThread implements Runnable{
    @Override
    public void run() {
            System.out.println(Thread.currentThread().getName());
    }
}
