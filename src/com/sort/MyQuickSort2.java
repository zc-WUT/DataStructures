package com.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MyQuickSort2 {
    public static void main(String[] args) {
//        int[] arr = {-9, 78, 0, 23, -567, 70, -700, -200, 50, 71, 23, 53};
        int[] arr = new int[80000]; // 平均27ms
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss  SSS");
        String form = simpleDateFormat.format(date);
        System.out.println(form);

        sort(arr, 0, arr.length - 1);

        Date date2 = new Date();
        String form2 = simpleDateFormat.format(date2);
        System.out.println(form2);
//        System.out.println(Arrays.toString(arr));

    }

    public static void sort(int[] arr, int left, int right) {
        int i = left;
        int j = right;
        int head = arr[left];

        while (i < j) {

            while (arr[j] >= head && i < j) {
                j--;
            }

            while (arr[i] <= head && i < j) {
                i++;
            }

            if (i != j) {
                int temp;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        arr[left] = arr[i];
        arr[i] = head;

        if (i - left > 1) {
            sort(arr, left, i - 1);
        }

        if (right - i > 1) {
            sort(arr, i + 1, right);
        }


    }
}
