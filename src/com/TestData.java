package com;

import java.util.HashSet;
import java.util.Map;

public class TestData {
  public int[][] rotateGrid(int[][] grid, int k) {
      int m=grid.length;
      int n=grid[0].length;
      int time=Math.min(m,n)/2;
      int[][] ans=new int[m][n];

      return null;
  }

  public void changeTop(int[][] grid,int[][] ans,int x,int y){
    for (int i = y*2; i < grid[x].length-y*2-1; i++) {
        ans[x][i]=grid[x][i+1];
    }
    ans[x][grid[x].length-y*2-1]=grid[x+1][grid[x].length-y*2-1];
  }
  public void changeDow(int[][] grid,int[][] ans,int x,int y){
    for (int i = grid[x].length-1-(grid.length-y-1)*2; i>(grid.length-y-1)*2; i--) {
      ans[x][i]=grid[x][i-1];
    }
    ans[x][(grid.length-y-1)*2]=grid[x][(grid.length-y-1)*2];
  }
  public void  changeLeft(int[][] grid,int[][] ans,int x,int y){
    for (int i = y*2; i < grid[x].length-y*2-1; i++) {
      ans[x][i]=grid[x][i+1];
    }
  }

  public static void main(String[] args) {
    String word="aba";
    long l = wonderfulSubstrings(word);
    System.out.println(l);
  }

  public static long wonderfulSubstrings(String word) {
    long ans=0L;
    for (int i = 0; i < word.length(); i++) {
      int time=0;
      HashSet<Character> set=new HashSet<>();
      for (int j = i; j < word.length(); j++) {
          if (set.contains(word.charAt(j))){
            set.remove(word.charAt(j));
          }else {
            set.add(word.charAt(j));
          }
          if (set.size()>1){
            continue;
          }
          ans++;
      }
    }
    return ans;
  }
}
