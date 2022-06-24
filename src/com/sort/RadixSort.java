package com.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {53, 3, 2, 542, 748, 14, 214};

/*        int[] arr = new int[20];
        for (int i = 0; i < 20; i++) {
            arr[i] = (int) (Math.random() * 80000000);
        }*/

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String form = simpleDateFormat.format(date);
        System.out.println(form);

        Sort(arr);
        System.out.println(Arrays.toString(arr));

        Date date2 = new Date();
        String form2 = simpleDateFormat.format(date2);
        System.out.println(form2);
    }

    public static void Sort(int[] arr) {
        //创建桶
        int[][] all_Tong = new int[10][arr.length];

        //每一个桶的位置索引集合
        int[] AllIndex = new int[10];//数组下标对应着桶的序号，下标对应的值初始为0，只要有数据进来，该桶的位置索引+1

        //先找到最大值，判断要把数据放入桶中，再从桶中取出的次数
        int maxV = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (maxV < arr[i]) {
                maxV = arr[i];
            }
        }
        int length = String.valueOf(maxV).length();

        //开始进行length次循环(最大值为几位数，就进行几次循环)
        for (int j = 0, n = 1; j < length; j++, n *= 10) {
            //遍历arr，将其放入对应的桶中
            for (int k = 0; k < arr.length; k++) {
                //通过余数判断arr[k]应该放入第num个桶中
                int num = arr[k] / n % 10;
                all_Tong[num][AllIndex[num]] = arr[k];
                //桶每存一个数据，该桶对应的位置索引向后移一位
                AllIndex[num]++;
            }

            //将全部桶中数据，按顺序放入arr中
            int index = 0;
            for (int l = 0; l < 10; l++) { //遍历每个桶
                if (AllIndex[l] != 0) { //排除空的桶
                    for (int m = 0; m < AllIndex[l]; m++) {
                        arr[index] = all_Tong[l][m];
                        index++;
                    }
                    //桶中的数据被全部取完
                    AllIndex[l] = 0;
                }
            }

        }

    }
}
