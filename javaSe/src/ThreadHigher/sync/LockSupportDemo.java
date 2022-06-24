package ThreadHigher.sync;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public class LockSupportDemo {
    public static void main(String[] args) {
        Thread t=new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                if (i==5){
                    LockSupport.park();//停止当前线程
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("8秒之后");
        LockSupport.unpark(t);//叫醒t线程
    }

}
