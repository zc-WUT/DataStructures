package com.sparsearray;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//稀疏数组
public class SparseArray {
    public static void main(String[] args) throws IOException {
        //创建一个原始的二维数组  11*11
        //0：表示没有棋子，1：表示黑子，2：表示蓝色子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        chessArr1[4][5] = 1;

        //输出原始的二维数组
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //将二维数组转为稀疏数组
        //先遍历二维数组，得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }

        //创建对应的稀疏数组
        int[][] sparseArr = new int[sum + 1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        //遍历二维数组，将非0值存放到稀疏数组中
        int count = 0; //计数器，用于记录第几个非0数据
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        FileWriter fos = new FileWriter("a.txt");
        for (int[] r : sparseArr) {
            for (int data : r) {
                fos.write(data + " ");
            }
            fos.write("\r\n");
        }
        fos.close();
        
        //输出稀疏数组的形式
        System.out.println();
        System.out.println("得到的稀疏数组如下======");
        for (int[] r : sparseArr) {
            for (int data : r) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

/*        //将稀疏数组恢复成二维数组
        //先读取第一行，创建原始的二维数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];

        //读取稀疏数组后几行的数据，并赋给二维数组
        for (int i =1;i<sparseArr.length;i++){
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] =sparseArr[i][2];
        }*/
        int[][] chessArr2 = new int[11][11];
        BufferedReader br = new BufferedReader(new FileReader("a.txt"));
        String line;
        while ((line = br.readLine()) != null) {
            String[] temp = line.split(" ");
            for (int i = 1; i < sparseArr.length; i++) {
                chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
            }
        }
        br.close();


        System.out.println();
        //输出恢复后的二维数组
        System.out.println("恢复后的二维数组");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

    }

}
