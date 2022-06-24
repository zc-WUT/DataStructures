package com.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MySelectSort {
    public static void main(String[] args) {
//        int[] arr = {34, 119, 101, 1, 120};
        int[] arr = new int[80000]; // 平均1s800ms
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
        int index;
        int idxValue;
        for (int i = 0; i < arr.length - 1; i++) {
            index = i;
            idxValue = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < idxValue) {
                    idxValue = arr[j];
                    index = j;
                }
            }
            if (index != i) {//没有找到比arr[i]小的数
                arr[index] = arr[i];
                arr[i] = idxValue;
            }
        }

/*        //找第一个最小值
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < idxValue) {
                idxValue = arr[i];
                index = i;
            }
        }
        arr[index] = arr[0];
        arr[0] = idxValue;

        index = 1;
        idxValue = arr[index];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] < idxValue) {
                idxValue = arr[i];
                index = i;
            }
        }
        arr[index] = arr[1];
        arr[1] = idxValue;

        index = 2;
        idxValue = arr[index];
        for (int i = 3; i < arr.length; i++) {
            if (arr[i] < idxValue) {
                idxValue = arr[i];
                index = i;
            }
        }
        arr[index] = arr[2];
        arr[2] = idxValue;*/
    }
}


