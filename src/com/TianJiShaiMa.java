package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TianJiShaiMa {

    public static void main(String[] args) {/*
        int[] A = {2, 7, 12, 6, 15, 3};
        int[] B = {1, 10, 5, 11, 14, 6};*/
        int[] A = {1, 3, 5, 7};
        int[] B = {2, 4, 6, 8};
        int[] ints = advantageCount(A, B);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }

    public static int[] advantageCount(int[] A, int[] B) {
        int size = A.length;
        int[] C = new int[size];
        List<Integer> D = new ArrayList<>(); //用来存B已经拿来判定过的数，由于后面对比，如果B取出来的数是D中已有，则直接跳过这个循环。
        List<Integer> G = new ArrayList<>(); //用来接收A中必输给B的马，B中必赢的马的编号
        List<Integer> H = new ArrayList<>(); //用来接收A中必赢马的数字。
        for (int h = 0; h < size; h++) {
            C[h] = A[h];
        }

        for (int i = 0; i < size; i++) {
            int num = 0;
            int[] E = new int[size]; //用于接收A-B大于0的差值，num表示有几个差值

            first:
            for (int j = 0; j < size; j++) {
                for (int k = 0; k < D.size(); k++) {//忽略已经比赛过的马
                    if (D.get(k) == B[j]) {
                        continue first;
                    }
                }

                if (A[i] - B[j] > 0) {
                    E[j] = A[i] - B[j];
                    num++;
                }
            }

            Arrays.sort(E);
            //此时，E中的最小值为E[E.length-num]
            int min;
            if (num!=0){
             min = E[E.length - num];
            }else {
                 min = 0;
            }
            for (int m = 0; m < size; m++) {
                if (A[i] - B[m] == min) {
                    H.add(A[i]);
                    C[m] = A[i];//A中的i马已经胜利
                    D.add(B[m]);
                }
            }
        }
        //比赛完毕，将A中输的马对应于B中赢的马
       second: for (int r=0;r<B.length;r++){
            for (int s=0;s<D.size();s++){//将B中赢了的马的序号放入G中
                if (D.get(s) == B[r]) {
                    continue second;
                }
            }
            G.add(r);
        }
        List<Integer> K=new ArrayList<>();//存放A中没有赢的马
       th: for (int u=0;u<size;u++){
            for (int v=0;v<H.size();v++){
                if (A[u]==H.get(v)){
                    continue th;
                }
            }
            K.add(A[u]);
        }
        for (int t=0;t<G.size();t++){
            //将C中对应着 t所对应的索引值，替换为A中输了的马
            C[G.get(t)]=K.get(t);
        }
        return C;
    }
}