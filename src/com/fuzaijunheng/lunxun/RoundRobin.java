package com.fuzaijunheng.lunxun;

import com.fuzaijunheng.ServerIps;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RoundRobin {
    private static Integer pos=0;
    public static String getServer(){
        if (pos>=ServerIps.LIST.size()){
            pos=0;
        }
        String ip = ServerIps.LIST.get(pos);
        pos++;
        return ip;

    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.println(getServer());
        }
    }
}
