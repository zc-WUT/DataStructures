package com.algorithm;

import java.awt.*;
import java.util.*;
import java.util.List;

public class HorseChessBoard {
    private static int X;//列数
    private static int Y;//行数
    //创建一个数组，标记棋盘的各个位置是否被访问过
    private static boolean visited[];
    //使用一个属性，标记是否棋盘的所有位置都被访问
    private static boolean finished; // 如果为true,表示成功

    public static void main(String[] args) {
        //测试
        X=8;
        Y=8;
        int[][] chessboard=new int[Y][X];
        visited=new boolean[X*Y];//默认都是false
        traversalChessBorad(chessboard,0,0,1);
        for (int[] ints : chessboard) {
            System.out.println(Arrays.toString(ints));
        }
    }

    /**
     * 完成骑士周游问题的算法
     *
     * @param chessboard 棋盘
     * @param row        马儿当前位置的行，从0开始
     * @param column     马当前的位置列，从0开始
     * @param step       是第几部步,初始就是第一步
     */
    public static void traversalChessBorad(int[][] chessboard, int row, int column, int step) {
        chessboard[row][column] = step;
        visited[row * X + column] = true;//该位置已经访问0
        //获取当前位置可以走的下一个位置的集合
        ArrayList<Point> ps = next(new Point(column, row));
        sort(ps);
        //遍历ps
        while (!ps.isEmpty()) {
            Point p = ps.remove(0);//取出下一个可以走的位置
            //判断该点是否已经访问过
            if (!visited[p.y * X + p.x]) {//没有被访问
                traversalChessBorad(chessboard, p.y, p.x, step + 1);
            }
        }
        //说明: step < X * Y  成立的情况有两种
        //1. 棋盘到目前位置,仍然没有走完
        //2. 棋盘处于一个回溯过程
        if (step < X * Y && !finished) {//没有走完
            chessboard[row][column] = 0;
            visited[row * X + column] = false;//棋盘还原
        } else {
            finished = true;
        }

    }

    /**
     * 功能： 根据当前位置(Point对象)，计算马儿还能走哪些位置(Point)，并放入到一个集合中(ArrayList), 最多有8个位置
     *
     * @param curPoint
     * @return
     */
    public static ArrayList<Point> next(Point curPoint) {
        //创建一个ArrayList
        ArrayList<Point> ps = new ArrayList<Point>();
        //创建一个Point
        Point p1 = new Point();
        //表示马儿可以走5这个位置
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走6这个位置
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走7这个位置
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走0这个位置
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走1这个位置
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走2这个位置
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走3这个位置
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y) {
            ps.add(new Point(p1));
        }
        //判断马儿可以走4这个位置
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y) {
            ps.add(new Point(p1));
        }
        return ps;
    }

    public static void sort(List<Point> ps){
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int size1 = next(o1).size();
                int size2 = next(o2).size();
                return size1-size2;
            }
        });
    }
}
