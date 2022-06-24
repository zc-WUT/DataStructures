package com.recursion;

public class MiGong{
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
        setWay(map,1,1);

        //输出新的地图，小球走过，并标识过的递归
        System.out.println("---------------------------------");
        for (int[] a:map){
            for (int i : a) {
                System.out.print(i +" ");
            }
            System.out.println();
        }
    }

    //使用递归回溯来给小球找路

    /**
     *
     * @param map 地图
     * @param i   从第几行开始
     * @param j   从第几列开始
     * @return 找得到路返回true
     */
    public static boolean setWay(int[][] map,int i,int j){
        if (map[6][1]==2){
            return true;
        }else {
            if (map[i][j]==0){
                map[i][j]=2;
                if (setWay(map,i+1,j)){//往下走看看
                    return true;
                }else if (setWay(map,i,j+1)){//往右走看看
                    return true;
                }else if (setWay(map,i-1,j)){//往上走看看
                    return true;
                }else if (setWay(map,i,j-1)){//往左走看看
                    return true;
                }else {
                    map[i][j]=3; //说明该点是死路
                    return false;
                }
            }else { //如果map[i][j]!=0,可能是1，2，3
                //直接返回false；
                return false;
            }
        }
    }

    public static boolean setWay2(int[][] map,int i,int j){
        if (map[6][1]==2){
            return true;
        }else {
            if (map[i][j]==0){
                map[i][j]=2;
                if (setWay2(map,i-1,j)){//往上走看看
                    return true;
                }else if (setWay2(map,i,j+1)){//往右走看看
                    return true;
                }else if (setWay2(map,i+1,j)){//往下走看看
                    return true;
                }else if (setWay2(map,i,j-1)){//往左走看看
                    return true;
                }else {
                    map[i][j]=3; //说明该点是死路
                    return false;
                }
            }else { //如果map[i][j]!=0,可能是1，2，3
                //直接返回false；
                return false;
            }
        }
    }
}
