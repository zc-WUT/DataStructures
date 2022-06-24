package com.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class HeapSort {
    public static void main(String[] args) {
        //要求将数组进行升序排序
        int[] arr={4,6,8,5,9};
/*        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }*/

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String form = simpleDateFormat.format(date);
        System.out.println(form);

        heapSort(arr);

        Date date2 = new Date();
        String form2 = simpleDateFormat.format(date2);
        System.out.println(form2);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr){
/*        adjustHeap(arr,1,arr.length);
        System.out.println(Arrays.toString(arr));
        adjustHeap(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));*/

        for (int i=arr.length/2-1;i>=0;i--){
            adjustHeap(arr,i,arr.length);
        }
        int temp;
        for (int j=arr.length-1;j>0;j--){
            temp=arr[j];
            arr[j]=arr[0];
            arr[0]=temp;
            adjustHeap(arr,0,j);
        }
    }

    //将一个数组（二叉树）调整成一个大顶堆
    /**
     * 功能：完成 将以i对应的非叶直接点的数调整成大顶堆 例： i=1,{4,6,8,5,9}  =====>adjustHeap=====> {4,9,8,5,6}
     * @param arr 待调整的数组
     * @param i 非叶子节点在数组中的索引
     * @param length 对多少个元素进行调整，length逐渐减小
     */
    public static void adjustHeap(int[] arr,int i,int length){
        int temp=arr[i]; //先取出当前元素的值，保存为临时变量
        //开始调整
        for (int k=i*2+1;k<length;k=k*2+1){
            if(k+1<length&&arr[k]<arr[k+1]){ //说明左子节点的值小于右子节点的值
                k++;
            }
            if (arr[k]>temp){ //如果子节点大于父节点
                arr[i]=arr[k];
                i=k; //i指向k，继续循环比较
            }else {
                break;
            }
        }
        //当for循环结束后，我们已经将以i为节点的数的最大值，放在了最顶上（局部大顶堆）
        arr[i]=temp; //将temp值放到调整后的位置
    }
}
