package com.queue;

public class MyArrayQueue {
    private int maxSize;
    private int front ;
    private int rear ;
    private int[] arr;

    public MyArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        front=0;
        rear=0;
        arr=new int[maxSize];
    }

    public boolean isFull(){
        if (rear>=arr.length){
            return true;
        }else {
            return false;
        }
    }

    public boolean isEmpty(){
        if (rear==front){
            return true;
        }else {
            return false;
        }
    }

    public void insert(int n){
        if (isFull()){
            return;
        }else {
            arr[rear]=n;
            rear++;
        }
    }

    public void get(){
        if (isEmpty()){
            throw new RuntimeException("队列空，无法取数据");
        }else {
            System.out.println(arr[front]);
            front++;
        }
    }

    public void showHeader(){
        if (isEmpty()){
            throw new RuntimeException("队列空，无法取数据");
        }else {
            System.out.println(arr[front]);
        }
    }

    public void showArray(){
        for (int num:arr){
            System.out.println(num);
        }
    }
}
