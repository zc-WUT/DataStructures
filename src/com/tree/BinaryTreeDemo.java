package com.tree;


public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "武松");
        HeroNode node3 = new HeroNode(3, "吴用");
        HeroNode node4 = new HeroNode(4, "晁盖");
        HeroNode node5 = new HeroNode(5, "林冲");

        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);
        binaryTree.setRoot(root);
/*        System.out.println("前序遍历");
        binaryTree.preOrder();
        System.out.println("中序遍历");
        binaryTree.infixOrder();
        System.out.println("后续遍历");
        binaryTree.postOrder();*/
        //前序查找
        System.out.println("前序查找");

        HeroNode heroNode = binaryTree.preOrderSearch(5);
        if (heroNode != null) {
            System.out.printf("找到了，信息为：no=%d  name=%s", heroNode.getNo(), heroNode.getName());
        } else {
            System.out.println("没有找到");
        }
    }
}

//定义一个二叉树
class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    //前序遍历
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    //中序遍历
    public void infixOrder() {
        if (this.root != null) {
            this.root.infixOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    //后序遍历
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    //前序查找
    public HeroNode preOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        } else {
            return null;
        }
    }

    public HeroNode infixOrderSearch(int no) {
        if (root != null) {
            return root.infixOrderSearch(no);
        } else {
            return null;
        }
    }

    public HeroNode postOrderSearch(int no) {
        if (root != null) {
            return root.postOrderSearch(no);
        } else {
            return null;
        }
    }

    public void delNode(int no){
        if (root!=null){
            if (root.getNo()==no){
                root=null;
            }else {
                root.delNode(no);
            }
        }else {
            System.out.println("空树不能删除");
        }
    }
}

