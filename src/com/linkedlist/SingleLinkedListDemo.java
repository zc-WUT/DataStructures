package com.linkedlist;

public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "武松", "打老虎");

        //创建单向链表
        SingleLinkedList singleLinkedList =new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);

        singleLinkedList.list();
    }

    //定义一个singlelinkedlist 管理我们的英雄.
    static class SingleLinkedList {
        //先初始化一个头节点
        private HeroNode head = new HeroNode(0, "", "");

        //添加节点到单向链表
        //不考虑编号的顺序时
        //先找到当前链表的最后一个节点，再将最后这个节点的next指向新的节点
        public void add(HeroNode heroNode) {

            //因为head节点不能动，因此我们需要一个辅助遍历temp
            HeroNode temp = head;
            while (true) {
                //找到链表的最后
                if (temp.next == null) {
                    break;
                }
                temp = temp.next;
            }
            //退出while时，说明temp指向了链表的最后
            temp.next=heroNode;
        }

        //显示链表
        public void list(){
            //判断链表是否为空
            if (head.next ==null){
                System.out.println("链表为空");
                return;
            }
            //因为头节点不能动，因此需要一个辅助变量来遍历
            HeroNode temp =head.next;
            while (true){
                //判断是否到了最后
                if (temp==null){
                    break;
                }
                System.out.println(temp);
                //将temp后移
                temp=temp.next;
            }
        }
    }

    //定义对象节点
    static class HeroNode {
        int no;
        String name;
        String nickname;
        HeroNode next;

        public HeroNode(int no, String name, String nickname) {
            this.no = no;
            this.name = name;
            this.nickname = nickname;
        }

        @Override
        public String toString() {
            return "HeroNode{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickname='" + nickname + '\'' +
                    '}';
        }
    }
}
