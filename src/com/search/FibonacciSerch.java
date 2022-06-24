package com.search;

import java.util.Arrays;

public class FibonacciSerch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 1000, 1234};
        int[] fib = {1, 1, 2, 3, 5, 8, 13};
        int search = search(arr, fib, 1234);
        System.out.println(search);
    }


    public static int search(int[] arr, int[] fib, int value) {
        int index = 0;
        while (arr.length - 1 > fib[index] - 1) {
            index++;
        }

        int[] temp = Arrays.copyOf(arr, fib[index]);
        for (int i = arr.length; i < temp.length; i++) {
            temp[i] = arr[arr.length - 1];
        }
//        System.out.println(Arrays.toString(temp));

        int left = 0;
        int right = arr.length - 1;
        int mid = 0;
        while (left <= right) {
            if (index == 0) {
                if (value == temp[right]) {
                    return right;
                }
                break;
            }

            mid = left + fib[index - 1] - 1; //如果index=0，会发生越界
            if (value < temp[mid]) {
                right = mid - 1;
                index--;
            } else if (value > temp[mid]) {
                left = mid + 1;
                index -= 2;
            } else {
                if (right < mid) {
                    return right;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }
}
