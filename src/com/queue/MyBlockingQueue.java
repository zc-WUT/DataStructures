package com.queue;

import com.MyAlgorithm;

import javax.xml.soap.Node;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue {
  private volatile List<Integer> arr = new ArrayList<>();
  private volatile Integer len = 3;

  public MyBlockingQueue(int len) {
    this.len = len;
  }

  public synchronized void add(Integer value) throws InterruptedException {
    while (arr.size() >= len) {
      System.out.println("队列已满");
      notifyAll();
      wait();
    }
    arr.add(value);
    notifyAll();
    System.out.println("添加成功:" + value+"    当前长度："+arr.size() );
  }

  public synchronized Integer get() throws InterruptedException {
    while (arr.size() == 0) {
      System.out.println("队列为空");
      notifyAll();
      wait();
    }
    System.out.println("消费成功:"+arr.get(0)+"    当前长度："+(arr.size()-1) );
    return arr.remove(0);
  }

}

class MyBlockQueueTest {
  public static void main(String[] args) {
    MyBlockingQueue queue = new MyBlockingQueue(5);
    Thread thread1 = new Thread(() -> {
      for (int i = 0; i < 100; i++) {
        try {
          Thread.sleep(100);
          queue.add(i);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    Thread thread2 = new Thread(() -> {
      for (; ; ) {
        try {
          Thread.sleep(200);
          queue.get();
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        try {
          Thread.sleep(800);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    });

    thread1.start();
    thread2.start();
  }
}
