package com.sort;

public class QuickSort {
    public static void main(String[] args) {
//        int[] arr = {-9, 78, 0, 23, -567, 70};
        int[] arr = {6, 3, 7, 9, 5, 1, 4, 8};
        sort(arr, 1, 5);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void sort(int[] arr, int left, int right) {
        int l = left; //左下标
        int r = right; //右下标
        //pivot 中轴值
        int pivot = arr[left];

        while (l != r) {
            while (arr[r] >= pivot && l < r) { //从右往左，直到找到一个不大于pivot的数
                r--;
            }

            while (arr[l] <= arr[pivot] && l < r) {//
                l++;
            }
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
        }

        arr[left] = arr[l];
        arr[l] = pivot;

        if (l - 1 > 0) {
            sort(arr, left, l - 1);
        }

        if (r + 1 < right) {
            sort(arr, r + 1, right);
        }
    }
}
