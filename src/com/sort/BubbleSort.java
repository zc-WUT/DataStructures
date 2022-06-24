package com.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class BubbleSort {
    public static void main(String[] args) {
//        int[] arr = {3, 9, -1, 10, -2};
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }

        boolean finish = false;
        int temp = 0;

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String form = simpleDateFormat.format(date);
        System.out.println(form);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1-i; j++) {
                finish=true;
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    finish = false;
                }
            }
            if (finish) {
                break;
            }
        }

        Date date2 = new Date();
        String form2 = simpleDateFormat.format(date2);
        System.out.println(form2);
/*        for (int i : arr) {
            System.out.println(i+" ");
        }*/
    }
}
