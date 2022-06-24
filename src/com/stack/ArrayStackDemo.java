package com.stack;

import java.util.Scanner;

public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack arrayStack=new ArrayStack(4);
        String key="";
        boolean loop=true; //是否退出菜单
        Scanner scanner =new Scanner(System.in);

        while (loop){
            System.out.println("s:表示显示栈");
            System.out.println("e:表示退出栈");
            System.out.println("a:表示添加数据到栈");
            System.out.println("p:取出数据");
            System.out.println("请输入你的选择");
            key=scanner.next();
            switch (key){
                case "s":
                    arrayStack.list();
                    break;
                case "a":
                    System.out.println("请输入一个数");
                    int next=scanner.nextInt();
                    arrayStack.push(next);
                    break;
                case "p":
                    arrayStack.pop();
                    break;
                case "e":
                    scanner.close();
                    loop=false;
                    break;
            }
        }
        System.out.println("程序退出成功");
    }
}

class ArrayStack{
    private int maxSize;
    private int[] stack;
    private int top =-1; //表示栈顶，初始化-1表示没有数据

    public ArrayStack(int maxsize){
        this.maxSize=maxsize;
        stack=new int[this.maxSize];
    }

    public boolean isFull(){
        return top==maxSize-1;
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public void push(int value){
        //先判断是否满
        if (isFull()){
            System.out.println("栈已满");
            return;
        }
        top++;
        stack[top]=value;
        System.out.println("压入"+value);
    }

    public void pop(){
        if (isEmpty()){
            System.out.println("空栈");
            return;
        }
        System.out.println("取出"+stack[top]);
        top--;
    }

    public void list(){
        if (isEmpty()){
            System.out.println("空栈");
            return;
        }
        int lien=top;
        while (true){
            if (lien==-1){
                break;
            }
            System.out.println(stack[lien]);
            lien--;
        }
    }
}
