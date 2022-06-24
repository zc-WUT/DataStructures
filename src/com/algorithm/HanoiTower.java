package com.algorithm;

public class HanoiTower {
    //分治算法求解汉诺塔问题
    public static void main(String[] args) {
        int[] i={1};
        hanoiTower(3,'a','b','c',i);

    }

    public static void hanoiTower(int num,char a,char b,char c,int[] i){
        //如果只有一个盘
        if (num==1){
            System.out.println(i[0]+"第1个盘"+a+"---->"+c);
            i[0]+=1;
        }else {
            //如果右n>=2情况，我们总是可以看做是两个盘：最下边的一个盘1，以及上面的所有盘2
            //1.先把最上面的盘 a-b,移动过程会使用到c
            hanoiTower(num-1,a,c,b,i);
            //2.把最下面的盘a-c.
            System.out.println(i[0]+"第"+num+"个盘"+a+"---->"+c);
            i[0]+=1;
            //3 把b柱的所有盘从b-c，移动过程使用到a塔
            hanoiTower(num-1,b,a,c,i);
        }
    }
}
