package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution implements Cloneable {
    public static void main(String[] args) {
        String ring = "xrrakuulnczywjs";
        String key = "jrlucwzakzussrlckyjjsuwkuarnaluxnyzcnrxxwruyr";
        int[] ans = {(ring.length()+1)*key.length()};
        findMin(0, 0, ring, key, ans, 0);
        ans[0] += key.length();
        System.out.println(ans[0]);
    }

    public static void findMin(int idx, int temp, String ring, String key, int[] ans, int len) {
        if (temp == key.length()) {
            if (ans[0] > len) {
                System.out.println(len);
                ans[0] = len;
            }
            return;
        }
        if (ans[0] <= len) {
            return;
        }
        int left = idx;
        int right = idx;
        int way = 0;
        while (!ring.substring(left, left + 1).equals(key.substring(temp, temp + 1))) {
            way += 1;
            left -= 1;
            if (left == -1) {
                left = ring.length() - 1;
            }
        }
        findMin(left, temp + 1, ring, key, ans, len + way);

        way = 0;
        while (!ring.substring(right, right + 1).equals(key.substring(temp, temp + 1))) {
            way += 1;
            right++;
            if (right == ring.length()) {
                right = 0;
            }
        }
        findMin(right, temp + 1, ring, key, ans, len + way);

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class MemoryCell {
    public Object read() {
        return storedValue;
    }

    private Object storedValue;
}