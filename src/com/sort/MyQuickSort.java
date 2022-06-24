package com.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyQuickSort {
    public static void main(String[] args) {
//        int[] arr = {-9, 78, 0, 23, -567, 70};
//        int[] arr = {6, 3, 7, 9, 5, 1, 4, 8};
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 80000000);
        }

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String form = simpleDateFormat.format(date);
        System.out.println(form);

        sort(arr, 0, arr.length - 1);

        Date date2 = new Date();
        String form2 = simpleDateFormat.format(date2);
        System.out.println(form2);
/*        for (int i : arr) {
            System.out.print(i + " ");
        }*/

    }

    public static void sort(int[] arr, int left, int right) {
        int l = left; //左下标
        int r = right; //右下标
        //pivot 中轴值
        int pivot = arr[l];
/*        if (left > right) {
            return;
        }*/

        while (l != r) {
            while (arr[r] >= pivot && l < r) { //从右往左，直到找到一个不大于pivot的数
                r--;
            }

            while (arr[l] <= pivot && l < r) {//
                l++;
            }


            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }

        arr[left] = arr[l];
        arr[l] = pivot;
        if (l-1>left){
        sort(arr, left, l - 1);}
        if (r+1<right){
        sort(arr, r + 1, right);}

    }
}
