package ThreadHigher.sync;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    public static void main(String[] args) {
        //允许多个线程共同执行
        Semaphore s=new Semaphore(2);
        new Thread(()->{
            try {
                s.acquire();//阻塞，减去1
                System.out.println("T1 running...");
                Thread.sleep(200);
                System.out.println("T1 running...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                s.release();//线程结束，回加1，其他线程就可以取1
            }
        }).start();

        new Thread(()->{
            try {
                s.acquire();//阻塞，减去1，如果已经为0则不会运行
                System.out.println("T2 running...");
                Thread.sleep(200);
                System.out.println("T2 running...");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                s.release();//线程结束，回加1
            }
        }).start();
    }
}
