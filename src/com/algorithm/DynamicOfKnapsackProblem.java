package com.algorithm;

import java.util.Arrays;

public class DynamicOfKnapsackProblem {
    public static void main(String[] args) {
        int[] w ={1,4,3}; //物品的重量
        int[] val={1500,3000,2000};
        int m=4; //背包的容量
        int n=val.length;//物品的个数

        //v[i][j]表示在前i个物品中，能装人容量为j的背包中的最大价值
        int[][] v=new int[n+1][m+1];
        //为了记录放入商品的情况，我们定一个二维数组
        int[][] path = new int[n+1][m+1];

        //第一行和第一列默认已经为0，故不需要进行初始化
        //根据前面得到公式来动态规划处理
        for(int i = 1; i < v.length; i++) { //不处理第一行 i是从1开始的
            for(int j=1; j < v[0].length; j++) {//不处理第一列, j是从1开始的
                //公式
                if(w[i-1]> j) { // 因为我们程序i 是从1开始的，因此原来公式中的 w[i] 修改成 w[i-1]
                    v[i][j]=v[i-1][j];
                } else {
                    //说明:
                    //因为我们的i 从1开始的， 因此公式需要调整成
                    //v[i][j]=Math.max(v[i-1][j], val[i-1]+v[i-1][j-w[i-1]]);
                    //v[i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]]);
                    //为了记录商品存放到背包的情况，我们不能直接的使用上面的公式，需要使用if-else来体现公式
                    if(v[i - 1][j] < val[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                        //把当前的情况记录到path
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }

                }
            }
        }

        for (int[] ints : v) {
            System.out.println(Arrays.toString(ints));
        }

        //动脑筋
        int i = path.length - 1; //行的最大下标
        int j = path[0].length - 1;  //列的最大下标
        while(i > 0 && j > 0 ) { //从path的最后开始找
            if(path[i][j] == 1) {
                System.out.printf("第%d个商品放入到背包\n", i);
                j -= w[i-1]; //w[i-1]
            }
            i--;
        }
    }
}
