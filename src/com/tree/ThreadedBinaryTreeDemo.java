package com.tree;

import java.util.ArrayList;
import java.util.List;

public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        HeroNode root = new HeroNode(1, "1");
        HeroNode node2 = new HeroNode(3, "3");
        HeroNode node3 = new HeroNode(6, "6");
        HeroNode node4 = new HeroNode(8, "8");
        HeroNode node5 = new HeroNode(10, "10");
        HeroNode node6 = new HeroNode(14, "14");
        HeroNode node7 = new HeroNode(15, "15");

        //二叉树递归创建。
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);
        node3.setRight(node7);

        //测试线索化
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setParent(root);
        threadedBinaryTree.threadedNodesPost(root);
        //当线索化二叉树后，不能再使用原来的遍历方法
        threadedBinaryTree.thrededListPost(root);
    }
}


//定义一个线索化二叉树
class ThreadedBinaryTree {
    private HeroNode root;

    //为了实现线索化，需要创建要指向当前节点的前驱节点
    private HeroNode pre = null; //在递归进行线索化时，总是保留前一个节点

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void setParent(HeroNode root){
        if (root.getLeft()!=null){
            root.getLeft().setParent(root);
            setParent(root.getLeft());
        }
        if (root.getRight()!=null){
            root.getRight().setParent(root);
            setParent(root.getRight());
        }
    }


    //遍历线索化中序二叉树的方法
    public void thrededList(HeroNode root) {
        HeroNode node = root;
        while (node != null) {
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }
            System.out.println(node);
            while (node.getRightType() == 1) {
                node = node.getRight();
                System.out.println(node);
            }
            node = node.getRight();
        }
    }

    //遍历线索化前序二叉树的方法
    public void thrededListpre(HeroNode root) {
        HeroNode node = root;
        while (node != null) {
            System.out.println(node);
            while (node.getLeftType() == 1) {
                if (node.getRightType() == 1) {
                    node = node.getRight();
                    System.out.println(node);
                } else {
                    return;
                }
            }
            node = node.getLeft();
        }
    }

    //遍历线索化后序二叉树的方法
    public void thrededListPost(HeroNode root) {
        HeroNode node = root;
        while (node != null && node.getLeftType() == 0) {
            node = node.getLeft();
        }

        HeroNode preNode = null;
        while (node != null) {
            //右节点是线索
            if (node.getRightType() == 1) {
                System.out.println(node);
                preNode = node;
                node = node.getRight();
            } else {
                //如果上个处理的节点是当前节点的右节点
                if (node.getRight() == preNode) {
                    System.out.println(node);
                    if (node == root) {
                        return;
                    }

                    preNode = node;
                    node = node.getParent();

                } else {    //如果从左节点的进入则找到有子树的最左节点
                    node = node.getRight();
                    while (node != null && node.getLeftType() == 0) {
                        node = node.getLeft();
                    }
                }
            }
        }
    }


    //编写对二叉树中序线索化的方法
    public void threadedNodes(HeroNode node) {
        //如果当前节点为空，无法线索化
        if (node == null) {
            return;
        }
        //先线索化左子树
        threadedNodes(node.getLeft());

        //线索化当前节点
        //先处理当前节点的前驱节点
        if (node.getLeft() == null) {
            //让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            node.setLeftType(1);
        }
        //再处理当前节点的后继节点
        if (pre != null && pre.getRight() == null) {
            //解释：AB挨着，那么：A的右边是B 等价于 B的左边是A
            pre.setRight(node);
            pre.setRightType(1);
        }
        //每处理一个节点后，让当前节点指向下一个节点
        pre = node;

        //线索化右节点
        threadedNodes(node.getRight());
    }

    //编写对二叉树前序线索化的方法
    public void threadedNodespre(HeroNode node) {
        //如果当前节点为空，无法线索化
        if (node == null) {
            return;
        }

        //线索化当前节点
        //先处理当前节点的前驱节点
        if (node.getLeft() == null) {
            //让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            node.setLeftType(1);
        }
        //再处理当前节点的后继节点
        if (pre != null && pre.getRight() == null) {
            //解释：AB挨着，那么：A的右边是B 等价于 B的左边是A
            pre.setRight(node);
            pre.setRightType(1);
        }
        //每处理一个节点后，让当前节点指向下一个节点
        pre = node;

        //线索化左子树
        if (node.getLeftType() == 0) {
            threadedNodespre(node.getLeft());
        }
        //线索化右节点
        if (node.getRightType() == 0) {
            threadedNodespre(node.getRight());
        }
    }

    //编写对二叉树后序线索化的方法
    public void threadedNodesPost(HeroNode node) {
        //如果当前节点为空，无法线索化
        if (node == null) {
            return;
        }
        //先线索化左子树
        threadedNodesPost(node.getLeft());

        //线索化右节点
        threadedNodesPost(node.getRight());

        //线索化当前节点
        //先处理当前节点的前驱节点
        if (node.getLeft() == null) {
            //让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            node.setLeftType(1);
        }

        //再处理当前节点的后继节点
        if (pre != null && pre.getRight() == null) {
            //解释：AB挨着，那么：A的右边是B 等价于 B的左边是A
            pre.setRight(node);
            pre.setRightType(1);
        }
        //每处理一个节点后，让当前节点指向下一个节点
        pre = node;

    }
}
