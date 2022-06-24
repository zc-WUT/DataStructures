package com.tree;

public class arrBinaryTressDemo {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7};
        //创建一个ArrBinaryTree
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder(0);
        System.out.println();
        arrBinaryTree.infixOrder(0);
    }


}

//实现顺序二叉树
class ArrBinaryTree{
    private int[] arr;

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //编写一个方法，完成顺序存储二叉树的一个前序遍历
    //index表示数组的下标
    public void  preOrder(int index){
        //如果数组为空，或arr.length=0
        if (arr==null||arr.length==0){
            System.out.print("数组为空，不能按照二叉树前序遍历");
        }
        //输出当前这个元素
        System.out.print(arr[index]);
        //向左递归遍历
        if (index*2+1<arr.length){
            preOrder(index*2+1);
        }
        //右递归
        if (index*2+2<arr.length){
            preOrder(index*2+2);
        }
    }
    public void  infixOrder(int index){
        //如果数组为空，或arr.length=0
        if (arr==null||arr.length==0){
            System.out.print("数组为空，不能按照二叉树前序遍历");
        }
        if (index*2+1<arr.length){
            infixOrder(index*2+1);
        }
        //输出当前这个元素
        System.out.print(arr[index]);
        //向左递归遍历

        //右递归
        if (index*2+2<arr.length){
            infixOrder(index*2+2);
        }
    }
}