package com.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MyMergeSort {
    public static void main(String[] args) {
//        int[] arr = {80, 40, 5, 7, 10, 3, 6, 2};
        int[] arr = new int[80000]; // 平均30ms
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss  SSS");
        String form = simpleDateFormat.format(date);
        System.out.println(form);

        int[] temp =new int[arr.length];
        mergeSort(arr,0,arr.length-1,temp);

        Date date2 = new Date();
        String form2 = simpleDateFormat.format(date2);
        System.out.println(form2);
//        System.out.println(Arrays.toString(arr));

    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int min = (right +left)/ 2;
            mergeSort(arr, left, min, temp);
            mergeSort(arr, min + 1, right, temp);
            merge(arr,left,min,right,temp);
        }

    }

    public static void merge(int[] arr, int left, int min, int right, int[] temp) {
        int i = left;
        int j = min + 1;
        int t = 0;

        while (i <= min && j <= right) {
            temp[t++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }

        while (i <= min) {
            temp[t++] = arr[i++];
        }
        while (j <= right) {
            temp[t++] = arr[j++];
        }


        t = 0;
        while (left <= right) {
            arr[left++] = temp[t++];
        }
    }
}
