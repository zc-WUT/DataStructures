package com.queue;

public class MyCircleArray {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public MyCircleArray(int maxSize) {
        this.maxSize = maxSize;
        front=0;
        rear=0;
        arr=new int[maxSize];
    }
    
    public boolean isFull(){
        return rear-front==maxSize;
    }
    
    public boolean isEmpty(){
        return front==rear;
    }
    
    public void insert(int n){
        if (isFull()){
            System.out.println("队列已满");
        }else {
            arr[(rear%maxSize)]=n;
            rear++;
        }
    }
    
    public void get(){
        if (isEmpty()){
            throw new RuntimeException("队列空，无法取数据");
        }else {
            System.out.println(arr[(front%maxSize)]);
            front++;
        }
    }

    public void showArr(){
        if (isEmpty()){
            throw new RuntimeException("队列空，无法取数据");
        }
        for (int i=front;i<rear;i++){
            System.out.println("arr["+i+"]的值为--"+arr[i%maxSize]);
        }
    }
    public void showHeader(){
        if (isEmpty()) {
            throw new RuntimeException("队列空，无法取数据");
        }else {
            System.out.println(arr[front%maxSize]);
        }
    }
}
