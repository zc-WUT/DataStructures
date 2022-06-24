package com.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertValueSearch {//插值查找

    public static void main(String[] args) {
        int[] arr = {1, 3, 7, 8, 8, 152, 321, 450};
//        int[] arr = new int[100];
/*        for (int i = 0; i < 100; i++) {
            arr[i] = i + 1;
        }*/

        List search = search(arr, 0, arr.length - 1, 9);
        System.out.println(search);

    }

    public static List search(int[] arr, int left, int right, int realValue) {
        if (left > right) {
            return null;
        }
        int index = left + (realValue - arr[left]) * (right - left) / (arr[right] - arr[left]);
        int indexValue = arr[index];

        if (realValue < indexValue) {
            System.out.println("找啊找");
            return search(arr, left, index - 1, realValue);
        } else if (realValue > indexValue) {
            System.out.println("找啊找");
            return search(arr, index + 1, right, realValue);
        } else {
            List list = new ArrayList();
            int temp = index - 1;
            while (temp >= 0 && arr[temp] == realValue) {
                list.add(temp);
                temp--;
            }

            list.add(index);
            temp = index + 1;
            while (temp <= right && arr[temp] == realValue) {
                list.add(temp);
                temp++;
            }
            return list;
        }

    }
}
