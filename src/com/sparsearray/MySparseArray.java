package com.sparsearray;

/**
 * 自己写一次二维数组转稀疏数组，稀疏数组再转二维数组的通用接口(数据只有0，1)
 */
public class MySparseArray {
    public int[][] chessArrToSparseArray(int[][] chessArr) {
        //获取元素个数
        int num = 0;
        //获取二维数组的行数和列数,从0开始
        int n = chessArr.length - 1;//行数
        int m = 0;//列数
        for (int[] ints : chessArr) {
            m = ints.length - 1;
            for (int anInt : ints) {
                if (anInt != 0) {
                    num++;
                }
            }
        }

        //创建稀疏数组
        int[][] sparseArray = new int[num + 1][3];
        sparseArray[0][0] = n + 1;//多少行
        sparseArray[0][1] = m + 1;//多少列
        sparseArray[0][2] = num;//多少个数据

        //遍历二维数组，将数据写入到稀疏数组
        int index = 1;
        for (int i = 0; i < chessArr.length; i++) {
            for (int j = 0; j < m; j++) {
                if (chessArr[i][j] != 0) {
                    sparseArray[index][0] = i;
                    sparseArray[index][1] = j;
                    sparseArray[index][2] = chessArr[i][j];
                    index++;
                }
            }
        }

        System.out.println("得到的稀疏数组如下======");
        for (int[] r : sparseArray) {
            for (int data : r) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        return sparseArray;
    }

    public static void main(String[] args) {
        MySparseArray mySparseArray =new MySparseArray();
        int[][] chessArr=new int[10][10];
        chessArr[1][1]=1;
        chessArr[2][2]=1;
        mySparseArray.chessArrToSparseArray(chessArr);
    }

}
