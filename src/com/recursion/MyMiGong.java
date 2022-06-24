package com.recursion;

public class MyMiGong {
    public static void main(String[] args) {
        int[][] map=new int[8][7];
        //使用1表示墙
        //上下全部为1
        map[3][1]=1;
        map[3][2]=1;
/*        map[6][4]=1;
        map[5][5]=1;*/
        for (int i=0;i<7;i++){
            map[0][i]=1;
            map[7][i]=1;
        }
        //左右全部为1
        for (int i=0;i<8;i++){
            map[i][0]=1;
            map[i][6]=1;
        }
        for (int[] a:map){
            for (int i : a) {
                System.out.print(i +" ");
            }
            System.out.println();
        }
        System.out.println("-----------------------");
        myMethod(map,1,1);
        for (int[] a:map){
            for (int i : a) {
                System.out.print(i +" ");
            }
            System.out.println();
        }
    }

    public static void myMethod(int[][] map,int i,int j) {
        //1表示墙，2表示走过，3表示从这点开始路走不通，返回
        if (map[6][1] == 2) {
            return ;
        }
        if (map[i][j]==0){
            map[i][j]=2;
        }else {
            return;
        }
        if (map[i][j+1]==0){
            myMethod(map,i,j+1);
            return;
        }else if (map[i+1][j]==0){
            myMethod(map,i+1,j);
            return;
        }else if (map[i][j-1]==0){
            myMethod(map,i,j-1);
            return;
        }else if (map[i-1][j]==0){
            myMethod(map,i-1,j);
            return;
        }else {
            map[i][j]=3;
            return;
        }
    }
}
