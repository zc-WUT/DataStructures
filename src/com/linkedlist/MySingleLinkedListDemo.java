package com.linkedlist;

public class MySingleLinkedListDemo {

    public static void main(String[] args) {
       HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
       HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
       HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
       HeroNode hero4 = new HeroNode(4, "武松", "打老虎");
       HeroNode hero5 = new HeroNode(5, "涛哥", "UZI");
       HeroNode hero6 = new HeroNode(6, "睿哥", "书记");
       HeroNode hero7 = new HeroNode(7, "宇哥", "财务");
       HeroNode hero8 = new HeroNode(8, "弛哥", "小弟");
        
        //创建单向链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        SingleLinkedList singleLinkedList2 = new SingleLinkedList();

//        singleLinkedList.update(new HeroNode(5, "武汉ZOO", "马了顶大！"));

        singleLinkedList.add(hero1);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero5);
        singleLinkedList.add(hero7);

        singleLinkedList2.add(hero2);
        singleLinkedList2.add(hero4);
        singleLinkedList2.add(hero6);
        singleLinkedList2.add(hero8);

/*        singleLinkedList.list();
        singleLinkedList.update(new HeroNode(5, "武汉ZOO", "马了顶大！"));*/
//        singleLinkedList.delete(3);
        singleLinkedList.combine(singleLinkedList2.head);
        singleLinkedList.list();
//        System.out.println("------------------");
//        singleLinkedList.reversetList();
//        singleLinkedList.list();

    }

    //定义一个singlelinkedlist 管理我们的英雄.
    static class SingleLinkedList {
        private HeroNode head = new HeroNode(0, "", "");

        //添加
        public void add(HeroNode heroNode) {
            HeroNode temp = head;
            while (true) {
                if (temp.next == null) {
                    break;
                } else {
                    temp = temp.next;
                }
            }
            temp.next = heroNode;
        }

        //按顺序添加
        public void add2(HeroNode heroNode) {
            HeroNode temp = head;

            while (true) {
                if (temp.no == heroNode.no) {
                    System.out.println("该数据已存在");
                    break;
                } else if (temp.next == null) {//将数据插入到最后一个的情况
                    temp.next = heroNode;
                    break;
                } else if (temp.next.no > heroNode.no && temp.no < heroNode.no) {//将数据插到中间
                    heroNode.next = temp.next;
                    temp.next = heroNode;
                    break;
                } else if (temp.next.no > heroNode.no && temp.no == 0) {//将数据插入第一个位置
                    heroNode.next = temp.next;
                    temp.next = heroNode;
                    break;
                } else {

                    temp = temp.next;
                }
            }
        }


        //更新操作，根据no编号修改，no不能改
        public void update(HeroNode newHeroNode) {
            HeroNode temp = head;
            if (head.next == null) {
                System.out.println("空链表你修改个鸡毛，傻屌");
                return;
            }
            while (true) {
                if (temp.no == newHeroNode.no) {
                    temp.name = newHeroNode.name;
                    temp.nickname = newHeroNode.nickname;
                    break;
                }
                if (temp.next == null) {
                    System.out.println("他妈的，你到底要更新哪个啊？");
                    break;
                }
                temp = temp.next;
            }
        }

        //删除一个节点
        public void delete(int no) {
            HeroNode temp = head;
            while (true) {
                if (temp.next == null) {
                    System.out.println("坑比，老子真不晓得你要删除哪个");
                    break;
                }
                if (temp.next.no == no) {
                    temp.next = temp.next.next;
                    break;
                }
                temp = temp.next;
            }
        }

        //显示链表
        public void list() {
            if (head.next == null) {
                System.out.println("链表为空");
                return;
            } else {
                HeroNode temp = head.next;
                while (true) {
                    if (temp.next == null) {
                        System.out.println(temp);
                        break;
                    }
                    System.out.println(temp);
                    temp = temp.next;
                }

            }
        }

        //按顺序合并两个链表
        public void combine(HeroNode head2) {
            if (head2.next == null) {
                System.out.println("没有东西你掉方法干嘛？");
                return;
            }
            HeroNode temp2 = head2.next;

            while (true) {
                if (temp2==null){
                    break;
                }
                HeroNode bt=new HeroNode();
                bt.no=temp2.no;
                bt.name=temp2.name;
                bt.nickname=temp2.nickname;
                bt.next=null;
                this.add2(bt);
                temp2= temp2.next;
            }
        }

        //单链表反转
        public void reversetList() {
            HeroNode tepm=head;
            if (tepm.next == null || tepm.next.next == null) {
                return;
            }

            HeroNode cur = tepm.next;
            HeroNode next = null;
            HeroNode reverseHead = new HeroNode(0, "", "");
            while (cur!= null) {
                next = cur.next;
                cur.next = reverseHead.next;
                reverseHead.next = cur;
                cur = next;
            }
            tepm.next = reverseHead.next;
        }
    }

    //定义对象节点
    static class HeroNode {
        int no;
        String name;
        String nickname;
        HeroNode next;

        public HeroNode() {
        }

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
