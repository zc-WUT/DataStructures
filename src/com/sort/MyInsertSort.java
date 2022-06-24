package com.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MyInsertSort {
    public static void main(String[] args) {
//        int[] arr = {101, 2, 34, 1, -2, -10, -5};
        int[] arr = new int[80000]; //平均1s100ms
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000000);
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
        int idx;
        int idxValue;
        for (int i = 1; i < arr.length; i++) {
            idx = i;
            idxValue = arr[i];
            while (idx > 0 && idxValue < arr[idx - 1]) {
                arr[idx] = arr[idx - 1];
                idx--;
            }
            //如果会发生交换，才会执行如下
            if (i != idx) {
                arr[idx] = idxValue;
            }

        }
    }
}
