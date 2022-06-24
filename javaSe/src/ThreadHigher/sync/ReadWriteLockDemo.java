package ThreadHigher.sync;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    static int value;
    static Lock lock=new ReentrantLock();
    static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static Lock readLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();

    public static void read(Lock lock) {
        lock.lock();
        try {
            Thread.sleep(1000);
            System.out.println("read");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void write(Lock lock, int v) {
        lock.lock();
        try {
            Thread.sleep(1000);
            value = v;
            System.out.println("write");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        for (int i=0;i<18;i++){new Thread(()->{read(lock);}).start();}
        for (int j=0;j<2;j++){new Thread(()->{write(lock,new Random().nextInt());}).start();}
    }
}
