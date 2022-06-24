package com.queue;

public class CircleArrayQueue {
    private int maxSize; //数组最大容量
    private int front;//队列头 现在初始值为0，指向队列的第一个元素
    private int rear;//队列尾 现在初始值为0，指向队列的最后一个元素的后一位。例：长度为3的数组，，刚开始存入两个数据以后，还没有循环，front指向的就是0，而rear指向的就是2，故由rear-front=2哥有效数据
    private int[] arr; //用于存放数据，模拟队列

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }

    //判断队列是否满了
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    //获取队列的数据，出队列
    public int getQueue() {
        //判断队列是否空
        if (isEmpty()) {
            throw new RuntimeException("队列空，无法取数据");
        }
        //这里需要分析出front时指向队列的第一个元素
        //先把front对应的值保存给一个临时变量，
        int value = arr[front];
        // 再将front后移
        front = (front + 1) % maxSize;
        //将保存的变量返回
        return value;
    }

    //显示队列的所有数据
    public void showQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，无法取数据");
        }
        //从front开锁遍历，遍历多少个元素就可以了
        for (int i = front; i < (rear - front + maxSize) % maxSize + front; i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    //显示队列的头数据，注意不是取出数据
    public  int headQueue(){
        if (isEmpty()){
            throw new RuntimeException("队列空，无法取数据");
        }
        return arr[front];
    }
}



