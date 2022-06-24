package com.fuzaijunheng.random;

import com.fuzaijunheng.ServerIps;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WeightRandom2 {
    public static String getServer(){
        int totalWeight=0;
        List<String> ips=new ArrayList<>();
        for (Integer weight : ServerIps.WEIGHT_MAP.values()) {
           totalWeight+=weight;
        }
        int offSet = new Random().nextInt(totalWeight);
        for (String s : ServerIps.WEIGHT_MAP.keySet()) {
            Integer weight = ServerIps.WEIGHT_MAP.get(s);
            if (offSet<weight){
                return s;
            }
            offSet-=weight;
        }
        return null;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getServer());
        }
    }
}
