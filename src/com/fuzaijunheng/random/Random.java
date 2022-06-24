package com.fuzaijunheng.random;

import com.fuzaijunheng.ServerIps;

public class Random {
    public static String getServer(){
        java.util.Random random=new java.util.Random();
        return ServerIps.LIST.get(random.nextInt(ServerIps.LIST.size()));
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getServer());
        }
    }
}
