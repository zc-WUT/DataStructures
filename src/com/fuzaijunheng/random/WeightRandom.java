package com.fuzaijunheng.random;

import com.fuzaijunheng.ServerIps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class WeightRandom {
    public static String getServer(){
        List<String> ips=new ArrayList<>();
        for (String s : ServerIps.WEIGHT_MAP.keySet()) {
            Integer weight=ServerIps.WEIGHT_MAP.get(s);
            ips.add(s);
        }
        Random random=new Random();
        return ips.get(random.nextInt(ips.size()));
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(getServer());
        }
    }
}
