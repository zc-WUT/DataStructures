package com.recursion;

import java.util.ArrayList;
import java.util.List;

class DifficultQueue8Question {

    public static void main(String[] args) {
        List<List<String>> lists = solveNQueens(8);
        System.out.println(lists);
    }

    public static List<List<String>> solveNQueens(int n) {
        int max=n;
        int[] arr =new int[max];
        List<List<String>> ans=new ArrayList<>();
        check(0,arr,n,ans);
        return ans;
    }

    public static void check(int k,int[] arr,int n,List<List<String>> ans){
        if(k==n){//找到了一种解法
            //将arr变化格式转换为List<String>
            List<String> exchange = exchange(arr, n);
            //将List<String>放入到List<List<String>>中
            ans.add(exchange);
            return;
        }
        for(int i=0;i<n;i++){
            arr[k]=i;
            if(judge(k,arr)){
                check(k+1,arr,n,ans);
            }
        }
    }

    public static boolean judge(int k,int[] arr){
        for(int i=0;i<k;i++){
            if(arr[i]==arr[k] || Math.abs(k-i)==Math.abs(arr[i]-arr[k])){
                return false;
            }
        }
        return true;
    }

    public static List<String> exchange(int[] arr,int n){
        List<String> que =new ArrayList<>();
        String st = new String();
        for (int j=0;j<n;j++){
            st=st+".";
        }
      //对一个arr，创建一个对应的初始que,是的里面的参数形式为 ["....","....","....","...."]
        for (int i=0;i<n;i++){
            que.add(st);
        }

        for (int m=0;m<n;m++){  //arr里的每一个参数都按顺序对应着que中的一个元素
            //arr的下标对应着行数，也对应着que里面第几个元素，根据 m 找到que对应的行，再根据arr[m]对应的列数，来修改que中对应行里的列所对应的元素
            //将.修改为Q
            StringBuilder strBuilder = new StringBuilder(que.get(m));
            strBuilder.setCharAt(arr[m], 'Q');
            que.set(m,strBuilder.toString());
        }
        return que;
    }
}
