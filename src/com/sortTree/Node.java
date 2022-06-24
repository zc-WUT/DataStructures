package com.sortTree;

class Node{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    /**
     * 查找要删除的节点
     * @param value 希望删除的节点的值
     * @return 如果找到返回该节点，否则返回null
     */
    public Node search(int value){
        if (value==this.value){
            return this;
        }else if (value<this.value){
            if (this.left==null){
                return null;
            }
            return this.left.search(value);
        }else {
            if (this.right==null){
                return null;
            }
            return this.right.search(value);
        }
    }

    //查找要删除结点的父结点
    /**
     *
     * @param value 要找到的结点的值
     * @return 返回的是要删除的结点的父结点，如果没有就返回null
     */
    public Node searchParent(int value) {
        //如果当前结点就是要删除的结点的父结点，就返回
        if((this.left != null && this.left.value == value) ||
                (this.right != null && this.right.value == value)) {
            return this;
        } else {
            //如果查找的值小于当前结点的值, 并且当前结点的左子结点不为空
            if(value < this.value && this.left != null) {
                return this.left.searchParent(value); //向左子树递归查找
            } else if (value >= this.value && this.right != null) {
                return this.right.searchParent(value); //向右子树递归查找
            } else {
                return null; // 没有找到父结点
            }
        }

    }

    //添加节点的方法
    public void add(Node node){
        if (node==null){
            return;
        }
        //判断传入的节点的值和当前子树的根节点的关系
        if (node.value<this.value){
            //如果当前节点左子节点为null
            if (this.left==null){
                this.left=node;
            }else {
                //递归左子树继续添加
                this.left.add(node);
            }
        }else { //添加的节点值岛屿当前节点的值
            if (this.right==null){
                this.right=node;
            }else {
                //递归右子树继续添加
                this.right.add(node);
            }
        }
    }

    //中序遍历
    public void infixOrder(){
        if (this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this.value);
        if (this.right!=null){
            this.right.infixOrder();
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
}
