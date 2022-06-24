package com.algorithm;

import java.util.*;

public class LRUCacheDemoNoJDK {

    private int cacheSize;
    Map<Integer, Node<Integer, Integer>> map;
    DoubleLinkedHashMap<Integer, Integer> doubleLinkedHashMap;

    public LRUCacheDemoNoJDK(int cacheSize) {
        this.cacheSize = cacheSize;
        map = new HashMap<>();
        doubleLinkedHashMap = new DoubleLinkedHashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        Node<Integer, Integer> node = map.get(key);
        doubleLinkedHashMap.removeNode(node);
        doubleLinkedHashMap.addHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node<Integer, Integer> node = map.get(key);
            node.value = value;
            map.put(key, node);
            doubleLinkedHashMap.removeNode(node);
            doubleLinkedHashMap.addHead(node);
        } else {
            if (map.size() == cacheSize) {//坑位满了
                Node<Integer, Integer> last = doubleLinkedHashMap.getLast();
                map.remove(last.key);
                doubleLinkedHashMap.removeNode(last);
            }
            //现在新增
            Node<Integer, Integer> newNode = new Node<>(key, value);
            map.put(key, newNode);
            doubleLinkedHashMap.addHead(newNode);
        }
    }

    class Node<K, V> {
        K key;
        V value;
        Node<K, V> pre;
        Node<K, V> next;

        public Node() {
            this.pre = this.next = null;
        }

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.pre = this.next = null;
        }
    }

    class DoubleLinkedHashMap<K, V> {
        Node<K, V> head;
        Node<K, V> tail;

        public DoubleLinkedHashMap() {
            head = new Node<>();
            tail = new Node<>();
            head.next = tail;
            tail.pre = head;
        }

        //添加到头
        public void addHead(Node<K, V> node) {
            node.next = head.next;
            node.pre = head;
            head.next.pre = node;
            head.next = node;
        }

        public void removeNode(Node<K, V> node) {
            node.next.pre = node.pre;
            node.pre.next = node.next;
            node.pre = null;
            node.next = null;
        }

        //获得最后一个节点
        public Node getLast() {
            return tail.pre;
        }
    }


    public static void main(String[] args) {
        LRUCacheDemoNoJDK lruCacheDemo = new LRUCacheDemoNoJDK(3);
        lruCacheDemo.put(1, 1);
        lruCacheDemo.put(2, 3);
        lruCacheDemo.put(3, 4);
        System.out.println(lruCacheDemo.map.keySet());

        lruCacheDemo.put(4, 4);
        System.out.println(lruCacheDemo.map.keySet());

        lruCacheDemo.put(3, 3);
        System.out.println(lruCacheDemo.map.keySet());
        lruCacheDemo.put(3, 3);
        System.out.println(lruCacheDemo.map.keySet());

        lruCacheDemo.put(5, 5);
        System.out.println(lruCacheDemo.map.keySet());
    }
}


class Solution2 {
    public Set<List<Integer>> combinationSum2(int[] cs, int t) {
        Arrays.sort(cs);
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> cur = new ArrayList<>();
        dfs(cs, t, 0, ans, cur);
        return ans;
    }

    /**
     * cs: 原数组，从该数组进行选数
     * t: 还剩多少值需要凑成。起始值为 target ，代表还没选择任何数；当 t = 0，代表选择的数凑成了 target
     * u: 当前决策到 cs[] 中的第几位
     * ans: 最终结果集
     * cur: 当前结果集
     */
   public void dfs(int[] arr,int target,int idx,Set<List<Integer>> ans,List<Integer> collect){
       if (target==0){
           ans.add(new ArrayList<>(collect));
           return;
       }
       if (target<0||idx>=arr.length){
           return;
       }
       collect.add(arr[idx]);
       dfs(arr,target-arr[idx],idx+1,ans,collect);
       collect.remove(collect.size()-1);
       dfs(arr,target,idx+1,ans,collect);
   }

    public static void main(String[] args) {
        int[] arr={10,1,2,7,6,1,5};
        Solution2 solution2=new Solution2();
        Set<List<Integer>> lists = solution2.combinationSum2(arr, 8);
        for (List<Integer> list : lists) {
                System.out.println(list);

        }
    }
}

