package com.linkedlist;

public class JosepfuQuestion {

    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList=new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.Josefu(1,2);
//        circleSingleLinkedList.showBoy();
    }
}

//创建一个环形的单向链表
class CircleSingleLinkedList {
    //创建一个first节点，先不编号
    private Boy first = null;

    public void addBoy(int nums) {
        //nums做一个数据校验
        if (nums < 1) {
            System.out.println("数据不正确");
            return;
        }

        Boy curBoy = null;
        //使用for循环创建环形链表
        for (int i = 1; i <= nums; i++) {
            //根据编号创建小孩节点
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first); //构成一个环
                curBoy = boy;
            } else {
                boy.setNext(first);
                curBoy.setNext(boy);

                curBoy = curBoy.getNext();
            }
        }

    }

    //遍历当前环形链表
    public void showBoy() {
        if (first==null){
            System.out.println("无话可说");
            return;
        }
        Boy curBoy=first;
        while (curBoy.getNext()!=first){
            System.out.println("这是第"+curBoy.getNo()+"个男孩");
            curBoy=curBoy.getNext();
        }
        System.out.println("这是第"+curBoy.getNo()+"个男孩");
    }

    //求解约瑟夫问题
    //从第k个人开始报数
    //数m下
    public  void  Josefu(int k,int m){
        if (first==null||k<1){
            return;
        }
        Boy helper=first;
        while (helper.getNext()!=first){
            helper=helper.getNext();
        }
        for (int i=0;i<k-1;i++){
            first=first.getNext();
            helper=helper.getNext();
        }
        while (helper!=first){
            for (int i=0;i<m-1;i++){
                first=first.getNext();
                helper=helper.getNext();
            }
            System.out.printf("小孩%d出圈\n",first.getNo());
            first=first.getNext();
            helper.setNext(first);
        }
        System.out.printf("最后留在圈中的小孩编号是%d \n",first.getNo());

    }
}

//创建一个boy类，表示一个节点
class Boy {
    private int no;
    private Boy next;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

    public Boy(int no) {
        this.no = no;
    }
}