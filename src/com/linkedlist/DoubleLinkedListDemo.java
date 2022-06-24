package com.linkedlist;

//双向链表
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "武松", "打老虎");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.delete(3);
        doubleLinkedList.list();
    }

    //创建双链表类
    static class DoubleLinkedList {
        private HeroNode2 head = new HeroNode2(0, "", "");


        //添加
        public void add(HeroNode2 heroNode) {
            HeroNode2 temp = head;
            while (true) {
                if (temp.next == null) {
                    break;
                } else {
                    temp = temp.next;
                }
            }
            temp.next = heroNode;
            heroNode.pre = temp;
        }


        //更新操作，根据no编号修改，no不能改
        public void update(HeroNode2 newHeroNode) {
            HeroNode2 temp = head;
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
            HeroNode2 temp = head.next;
            if (temp.next == null) {
                System.out.println("空链表");
                return;
            }
            while (true) {
                if (temp == null) {
                    System.out.println("坑比，老子真不晓得你要删除哪个");
                    break;
                }
                if (temp.no == no) {
                    temp.pre.next = temp.next;
                    if (temp.next != null) {
                        temp.next.pre = temp.pre;
                    }
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
                HeroNode2 temp = head.next;
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

    }

    //创建双线链表节点
    static class HeroNode2 {
        int no;
        String name;
        String nickname;
        HeroNode2 next;
        HeroNode2 pre;

        public HeroNode2() {
        }

        public HeroNode2(int no, String name, String nickname) {
            this.no = no;
            this.name = name;
            this.nickname = nickname;
        }

        @Override
        public String toString() {
            return "HeroNode2{" +
                    "no=" + no +
                    ", name='" + name + '\'' +
                    ", nickname='" + nickname + '\'' +
                    '}';
        }
    }
}
