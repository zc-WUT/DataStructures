package com.tree;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner cin = new Scanner(System.in, StandardCharsets.UTF_8.name());
    String initState = cin.next();
    String dstState = cin.next();
    cin.close();
    int result = unlock(initState, dstState);
    System.out.println(result);
  }

  private static int unlock(String initState, String dstState) {
    // 在此补充你的代码
    if (!isPrime(Integer.valueOf(dstState))) {
      return -1;
    }
    return bfs(initState,dstState);
  }

  public static int bfs(String initState, String dstState) {
    List<String> queue = new ArrayList<>();
    HashSet<String> set = new HashSet<>();
    set.add(initState);
    queue.add(initState);
    int hight=0;
    while (queue.size()!=0 ) {
      System.out.print(queue.toString());
      System.out.println();
      hight+=1;
      int size=queue.size();
      for (int k=0;k<size;k++){
        String s = queue.remove(0);
        for (int i = 0; i < 4; i++) {
          char[] chars = s.toCharArray();
          int temp = chars[i];
          for (int j = 0; j < 10; j++) {
            if (chars[i] == (char) (j + '0')) {
                continue;
            }
            chars[i] = (char) (j + '0');
            String ss = "";
            for (char aChar : chars) {
              ss += aChar;
            }
            if (set.contains(ss)) {
              chars[i] = (char) (temp);
              continue;
            }
            set.add(ss);
            Integer integer = Integer.valueOf(ss);
            if (isPrime(integer)) {
              String tt = String.valueOf(integer);
              while (tt.length() < 4) {
                tt = "0" + tt;
              }
              queue.add(tt);
            }
            if (ss.equals(dstState)) {
              return hight;
            }
          }
        }
      }
    }
    return -1;
  }


  public static boolean isPrime(int num) {
    if (num <= 3) {
      return num > 1;
    }
    // 不在6的倍数两侧的一定不是质数
    if (num % 6 != 1 && num % 6 != 5) {
      return false;
    }
    int sqrt = (int) Math.sqrt(num);
    for (int i = 5; i <= sqrt; i += 6) {
      if (num % i == 0 || num % (i + 2) == 0) {
        return false;
      }
    }
    return true;
  }
}


