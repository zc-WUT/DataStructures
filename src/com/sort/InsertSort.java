package com.sort;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class InsertSort {
    public static void main(String[] args) {
//        int[] arr ={101,119,34,1};
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000000);
        }
        insert(arr);
    }

    public static void insert(int[] arr) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String form = simpleDateFormat.format(date);
        System.out.println(form);
        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            int insertIdx = i - 1;
            while (insertIdx >= 0 && insertValue < arr[insertIdx]) {
                arr[insertIdx + 1] = arr[insertIdx];
                insertIdx--;
            }
            if (insertIdx + 1 != i) {
                arr[insertIdx + 1] = insertValue;
            }
        }

        List<String> s =new ArrayList<>();
        Date date2 = new Date();
        String form2 = simpleDateFormat.format(date2);
        System.out.println(form2);
/*        for (int i : arr) {
            System.out.print(i + " ");
        }*/
    }
}
