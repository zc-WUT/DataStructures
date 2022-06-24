package com.algorithm;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheDemo<K, V> extends LinkedHashMap<K, V> {

    private int capacity;

    /**
     * accessOrder 访问顺序
     *      如果为true：会令被访问的缓存作为最新的缓存
     *      如果为false：只能按照创建时间进行生命排序
     *
     * @param capacity
     */
    public LRUCacheDemo(int capacity) {
        super(capacity, 0.75F, false);
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return super.size() > capacity;
    }

    public static void main(String[] args) {
        LRUCacheDemo lruCacheDemo = new LRUCacheDemo(3);
        lruCacheDemo.put(1, "a");
        lruCacheDemo.put(2, "b");
        lruCacheDemo.put(3, "c");
        System.out.println(lruCacheDemo.keySet());

        lruCacheDemo.put(4, "d");
        System.out.println(lruCacheDemo.keySet());

        lruCacheDemo.put(3, "c");
        System.out.println(lruCacheDemo.keySet());
        lruCacheDemo.put(3, "c");
        System.out.println(lruCacheDemo.keySet());

        lruCacheDemo.put(5, "e");
        System.out.println(lruCacheDemo.keySet());

    }
}




