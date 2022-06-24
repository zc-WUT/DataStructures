package com.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MyBubbleSort {
    public static void main(String[] args) {
//        int[] arr = {3, 9, -1, 10, -2};
        int[] arr = new int[80000]; // 平均9s300ms
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss  SSS");
        String form = simpleDateFormat.format(date);
        System.out.println(form);

        sort(arr);

        Date date2 = new Date();
        String form2 = simpleDateFormat.format(date2);
        System.out.println(form2);
//        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        int temp;
        //五个数就就需要进行4次循环，n个数需要n-次循环。
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++){
                if (arr[j]>arr[j+1]){
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        //需要四次才能排完
/*        for (int i=0;i<arr.length-1;i++){
            if (arr[i]>arr[i+1]){
                temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }
        }

        for (int i=0;i<arr.length-1-1;i++){
            if (arr[i]>arr[i+1]){
                temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }
        }

        for (int i=0;i<arr.length-1-1-1;i++){
            if (arr[i]>arr[i+1]){
                temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }
        }

        for (int i=0;i<arr.length-1-1-1-1;i++){
            if (arr[i]>arr[i+1]){
                temp=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=temp;
            }
        }*/
    }
}
