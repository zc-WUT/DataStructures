package com.search;

public class BinarySearchNoRecursion {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        int i = binarySearchNoRecursion(arr, 2);
        System.out.println(i);

    }

    //不用递归实现二分查找
    public static int binarySearchNoRecursion(int[] arr,int target){
        int left=0;
        int right=arr.length-1;
        int mid;
        while (left!=right){
            mid=(left+right)/2;
            if (arr[mid]<target){
                left=mid+1;
            }else if (arr[mid]>target){
                right=mid-1;
            }else {
                return mid;
            }
        }
        return -1;
    }
}
