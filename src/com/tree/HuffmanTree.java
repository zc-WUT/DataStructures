package com.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
    public static void main(String[] args) {
        int[] arr = {13, 7, 8, 3, 29, 6, 1};
        Node huffmanTree = createHuffmanTree(arr);
        System.out.println(huffmanTree);
        huffmanTree.preOrder();

    }

    //创建霍夫曼树方法
    public static Node createHuffmanTree(int[] arr) {
        //第一步，遍历arr数组
        //第二步将arr的每个元素构成一个Node
        //将Node放入到ArrayList中
        List<Node> nodes = new ArrayList<>();
        for (int value : arr) {
            nodes.add(new Node(value));
        }
        Collections.sort(nodes);


        while (nodes.size() > 1) {
            Node left = nodes.get(0);
            Node right = nodes.get(1);
            nodes.remove(0);
            nodes.remove(0);
            Node newNode = new Node(left.value + right.value);
            newNode.left=left;
            newNode.right=right;
            nodes.add(newNode) ;
            Collections.sort(nodes);
        }
       return nodes.get(0);
    }
}

class Node implements Comparable<Node> {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    //前序遍历
    public void preOrder(){
        System.out.println(this.value);
        if (this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        //表示从小到大的排序
        return this.value - o.value;
    }
}
