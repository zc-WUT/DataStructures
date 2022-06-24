package com.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SelectSort {
    public static void main(String[] args) {
//        int[] arr ={34,119,101,1,120};
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000000);
        }
        sort(arr);
    }

    public static int[] sort(int[] arr){
//        int value;
        int time=0;
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String form = simpleDateFormat.format(date);
        System.out.println(form);

        for (int i=0;i<arr.length-1;i++){
//            boolean brk=true;
            int miniIndex=i;
            int minVlue=arr[i];

            for (int j=i+1;j<arr.length;j++){
                if (minVlue>arr[j]){
                    minVlue=arr[j];
                    miniIndex=j;
                }
            }

            if (miniIndex!=i){
                arr[miniIndex]=arr[i];
                arr[i]=minVlue;
            }
//            time++;
/*            if (brk){
                break;
            }*/
/*            System.out.printf("第%d次得到结果",time);

            for (int a : arr) {
                System.out.print(a+" ");
            }
            System.out.println();*/
        }
//        System.out.println(time);
        Date date2 = new Date();
        String form2 = simpleDateFormat.format(date2);
        System.out.println(form2);
        return  arr;
    }
}
