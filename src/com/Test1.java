package com;

import com.stack.Test;
import sun.applet.AppletClassLoader;

import java.util.*;
import java.util.concurrent.*;

public class Test1 extends ClassLoader {
    public static void main(String[] args) {
      System.out.println(1 << 1);
      LinkedBlockingQueue linkedBlockingQueue= new LinkedBlockingQueue();
      ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, linkedBlockingQueue);
    }

}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
