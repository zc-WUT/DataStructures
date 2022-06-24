package com.queue;

//使用数组模拟一个队列-编写一个ArrayQueue类
public class ArrayQueue {
    private int maxSize; //数组最大容量
    private int front;//队列头
    private int rear;//队列尾
    private int[] arr; //用于存放数据，模拟队列

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1; //指向队列数据头部，没有数据时，分析出front是指向队列头的前一个位置
        rear = -1; //指向队列的尾部数据，包含（即）队列最后一个数据
    }

    //判断队列是否满了
    public boolean isFull() {
        return rear >= maxSize - 1;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n){
        if (isFull()){
            System.out.println("队列已满");
            return;
        }
        rear++;
        arr[rear] =n;
    }

    //获取队列的数据，出队列
    public int getQueue(){
        //判断队列是否空
        if (isEmpty()){
            throw new RuntimeException("队列空，无法取数据");
        }
        front ++;
        return arr[front];
    }

    //显示队列的所有数据
    public void  showQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空，无法取数据");
        }
        for (int i=0;i<arr.length;i++){
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }

    //显示队列的头数据，注意不是取出数据
    public  int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空，无法取数据");
        }
        return arr[front+1];
    }
}

