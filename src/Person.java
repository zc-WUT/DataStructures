import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Person implements Cloneable {
    private int age;
    private String name;

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public Person() {
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

class Solution {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        head.next=new ListNode(4);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(2);
        head.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next=new ListNode(2);
        partition(head,3);
    }

    public static ListNode partition(ListNode head, int x) {
        List<Integer> list=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null){
            if(temp.val<x){
                list.add(temp.val);
            }else{
                list2.add(temp.val);
            }
            temp=temp.next;
        }
        Collections.sort(list);
        Collections.sort(list2);
        for(int i:list){
            if(temp!=null){
                temp.val=i;
                temp=temp.next;
            }

        }
        for(int i:list2){
            if(temp!=null){
                temp.val=i;
                temp=temp.next;
            }
        }
        return head;
    }
}



