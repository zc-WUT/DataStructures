package com.algorithm;

import java.util.Arrays;

public class KMP {
    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        int[] next = kmpNext(str2);
        System.out.println(Arrays.toString(next));
        int i = kmpSearch(str1, str2, next);
        System.out.println(i);
    }

    //写出我们的kmp搜索算法
    /**
     *
     * @param str1 源字符串
     * @param str2 子串
     * @param next 部分匹配表, 是子串对应的部分匹配表
     * @return 如果是-1就是没有匹配到，否则返回第一个匹配的位置
     */
    public static int kmpSearch(String str1, String str2, int[] next) {
        for (int i=0,idx2=0;i<str1.length();i++){
            //需要处理 str1.charAt(i) ！= str2.charAt(j), 去调整j的大小
            //KMP算法核心点, 可以验证...
            if (idx2>0&&str1.charAt(i)!=str2.charAt(idx2)){
                idx2=next[idx2-1];
            }

            if (str1.charAt(i)==str2.charAt(idx2)){
                idx2++;
            }
            if (idx2==str2.length()){
                return i-idx2+1;
            }
        }
        return -1;
    }

    //获取到子字串的部分匹配值
    public static  int[] kmpNext(String dest) {
        //创建一个next 数组保存部分匹配值
        int[] next = new int[dest.length()];
        next[0] = 0; //如果字符串是长度为1 部分匹配值就是0
        for(int i = 1, j = 0; i < dest.length(); i++) {
            //当dest.charAt(i) != dest.charAt(j) ，我们需要从next[j-1]获取新的j
            //直到我们发现 有  dest.charAt(i) == dest.charAt(j)成立才退出
            //这时kmp算法的核心点
            while(j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j=next[j-1];
            }

            //当dest.charAt(i) == dest.charAt(j) 满足时，部分匹配值就是+1
            if(dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
