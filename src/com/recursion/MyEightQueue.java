package com.recursion;

public class MyEightQueue {
    //定义一个max，表示多少个皇后
    int max=8;
    //定义一个数组，保存皇后放置位置的结果，比如arr={0,4,7,5,2,6,1,3}
    int[] arr =new int[max];
    static int count=0;
    public static void main(String[] args) {

        MyEightQueue eightQueue=new MyEightQueue();
        eightQueue.check(0);
        System.out.println("一共有"+count+"次解法");
    }

    //编写一个方法，从第n个皇后开始放置
    private void check(int n){
        if (n==max){
            print();
            return;
        }
        for (int i=0;i<max;i++){
            arr[n]=i;
            if (judge(n)){
                check(n+1);
            }
        }
    }

    //查看当我们放置第n个皇后，就去监测皇后是否和前面已经拜访的皇后冲突
    /**
     *
     * @param n 表示放第n个皇后
     * @return
     */
    private  boolean judge(int n){
        for (int i=0;i<n;i++){
            if (arr[i]==arr[n]||Math.abs(n-i)==Math.abs(arr[n]-arr[i])){
                return false;
            }
        }
        return true;
    }

    //将皇后拜访的位置输出
    private void print(){
        count++;
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
