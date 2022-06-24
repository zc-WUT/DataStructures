package com.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MyRadixSort {
    public static void main(String[] args) {
//        int[] arr = {53, 4, 3, 542, 748, 14, 214, 32, 56, 78, 69};
        int[] arr = new int[80000]; // 平均25ms
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }

        int[][] all_Tong = new int[10][arr.length];
        int[] all_Index = new int[10];

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss  SSS");
        String form = simpleDateFormat.format(date);
        System.out.println(form);

        sort(arr, all_Tong, all_Index);

        Date date2 = new Date();
        String form2 = simpleDateFormat.format(date2);
        System.out.println(form2);

//        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr, int[][] all_Tong, int[] all_Index) {
        int temp = 0;
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (maxValue < arr[i]) {
                maxValue = arr[i];
            }
        }
        int size = String.valueOf(maxValue).length();

        for (int j = 0, n = 1; j < size; j++, n *= 10) {

            for (int k = 0; k < arr.length; k++) {
                int idx = arr[k] / n % 10;
                all_Tong[idx][all_Index[idx]] = arr[k];
                all_Index[idx]++;
            }

            int index = 0;
            for (int m = 0; m < 10; m++) {
                if (all_Index[m] != 0) {
                    for (int p = 0; p < all_Index[m]; p++) {
                        arr[index++] = all_Tong[m][p];
                    }
                    all_Index[m] = 0;
                }

            }
        }
    }
}
