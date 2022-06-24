package com.stack;

public class LinkedListStackDemo {
    public static void main(String[] args) {

        LinkedListStack a=new LinkedListStack(1,2);
        LinkedListStack b=new LinkedListStack(2,3);
        LinkedListStack c=new LinkedListStack(3,4);
        LinkedListStack d=new LinkedListStack(4,5);
        LinkedListStack e=new LinkedListStack(5,6);

        LinkedList linkedList=new LinkedList();

        linkedList.push(a);
        linkedList.push(b);
        linkedList.push(c);
        linkedList.push(d);
        linkedList.push(e);

        linkedList.pop();
        System.out.println("-----");
        linkedList.List();

    }
}

class LinkedList{
    LinkedListStack head =new LinkedListStack(0);

    public void push(LinkedListStack newStack){
        newStack.next=head.next;
        head.next=newStack;
        System.out.println("添加完成");
    }

    public void pop(){
        if (head.next==null){
            System.out.println("空栈");
            return;
        }
        System.out.println(head.next.no);
        head.next=head.next.next;
    }

    public void List(){
        if (head.next==null){
            System.out.println("空栈");
            return;
        }
        LinkedListStack temp=head;
        while (temp.next!=null){
            System.out.println(temp.next.no);
            temp=temp.next;
        }
    }
}

class LinkedListStack {
    int no;
    int value;
    LinkedListStack next;

    public LinkedListStack(int no,int value) {
        this.no = no;
        this.value=value;
    }
    public LinkedListStack(int no) {
        this.no = no;
    }


    @Override
    public String toString() {
        return "LinkedListStack{" +
                "no=" + no +
                ", value=" + value +
                '}';
    }
}