package com.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {1,3,2,9,8,7,6,4,5, 0};
//        int[] arr = new int[8];
//        for (int i = 0; i < 8; i++) {
//            arr[i] = (int) (Math.random() * 8000000);
//        }

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String form = simpleDateFormat.format(date);
        System.out.println(form);

        shell(arr);

        Date date2 = new Date();
        String form2 = simpleDateFormat.format(date2);
        System.out.println(form2);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void shell(int[] arr) {
        for (int i = arr.length / 2; i > 0; i = i / 2) {
            for (int j = i; j < arr.length; j++) {
                int index = j;
                int idxValue = arr[index];
                    while (index - i >= 0 && idxValue < arr[index - i]) {
                        arr[index] = arr[index - i];
                        index -= i;
                    }
                    arr[index] = idxValue;
            }
        }


/*        for (int i = arr.length / 2; i > 0; i = i / 2) {
            for (int j = i; j < arr.length; j++) {
                int temp;
                for (int k = j - i; k >= 0; k -= i) {
                    if (arr[k] > arr[k + i]) {
                        temp = arr[k];
                        arr[k] = arr[k + i];
                        arr[k + i] = temp;
                    }
                }
            }
        }*/
    }
}
