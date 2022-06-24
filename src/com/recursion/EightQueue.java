package com.recursion;

import java.util.ArrayList;
import java.util.List;

public class EightQueue {
    //定义一个max，表示多少个皇后
    int max=8;
    //定义一个数组，保存皇后放置位置的结果，比如arr={0,4,7,5,2,6,1,3}
    int[] arr =new int[max];
    static int count=0;
    public static void main(String[] args) {
        EightQueue eightQueue=new EightQueue();
        eightQueue.check(0);
        System.out.println("一共有"+count+"次解法");
    }

    //编写一个方法，放置第n个皇后
    private  void check(int n){
        if (n==max){
            print();
            return;
        }
        //依次放入皇后并判断是否冲突
        for (int i=0;i<max;i++){
            //先把当前皇后n，放到该行的第一列
            arr[n]=i;
            //当放置到第n个皇后i时，是否冲突
            if (judge(n)){
                //接着放第n+1个皇后，即开始递归
                check(n+1);
            }
            //如果冲突，就继续执行arr[n]=i
        }
    }

    //查看当我们放置第n哥皇后，就去监测皇后是否和前面已经拜访的皇后冲突
    /**
     *
     * @param n 表示放第n个皇后
     * @return
     */
    private  boolean judge(int n){
        for (int i=0;i<n;i++){
            //arr[i]==arr[n] 表示判断第n个皇后是否和前面的n-1个皇后在同一列
            //Math.abs(n-i)==Math.abs(arr[n]-arr[i]) ： 两个皇后列的差值，如果等于行的差值，那就说明这两个皇后在同一斜线上
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
