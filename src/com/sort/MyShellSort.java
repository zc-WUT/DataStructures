package com.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MyShellSort {
    public static void main(String[] args) {
//        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0,11,7,26,48,95,13};
        int[] arr = new int[80000]; //用时30ms
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
        int idx;
        int idxValue;
        for (int j = arr.length / 2; j > 0; j /= 2) {
            for (int i = j; i < arr.length; i++) {
                idx = i;
                idxValue = arr[i];
                while (idx - j >= 0 && idxValue < arr[idx - j]) {
                    arr[idx] = arr[idx - j];
                    idx -= j;
                }
                if (i != idx) {
                    arr[idx] = idxValue;
                }
            }
        }

    }
}
