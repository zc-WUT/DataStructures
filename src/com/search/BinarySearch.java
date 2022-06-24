package com.search;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={1,1000,1000,1000,1000,1000,1000};
        List<Integer> searchs = search(arr, 0, arr.length - 1, 1000);
        if (searchs==null){
            System.out.println("找不到");
        }else {
            Collections.sort(searchs);
            System.out.println("找到的结果  "+searchs);
        }

    }
    public static List<Integer> search(int[] arr, int left, int right, int realValue){

        if (left>right){
            return null;
        }

        int middle=(left+right)/2;
        int middleValue=arr[middle];

        if (realValue<middleValue){
            return search(arr,left,middle-1,realValue);
        }else if (realValue>middleValue){
            return search(arr,left+1,right,realValue);
        }else {
            List<Integer> list=new ArrayList<>();
            int temp=middle-1;
            while(temp>=0&&arr[temp]==realValue){//中间开始往左找
                list.add(temp);
                temp--;
            }

            list.add(middle);
            temp=middle+1;
            while (temp<=right&&arr[temp]==realValue){ //中间开始往右找
                list.add(temp);
                temp++;
            }
            return list;
        }
    }
}
