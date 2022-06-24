package com.queue;

import java.util.Scanner;

public class ArrayQueueDemo {
    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' '; //接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据");
            System.out.println("g(get):取出数据");
            System.out.println("h(head):查看队列头数据");
            key = scanner.next().charAt(0);//接受一个字符
            switch (key) {
                case 's':
                    try {
                        arrayQueue.showQueue();
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'a':
                    System.out.println("输入一个数字");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g': //取数据
                    try{
                        int res =arrayQueue.getQueue();
                        System.out.printf("取出的数据是：%d\n",res);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': //查看队列头的数据
                    try{
                        int res = arrayQueue.headQueue();
                        System.out.printf("队列头的数据是：%d\n",res);
                    }catch (Exception e){
                        e.getMessage();
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop=false;
                    break;
                default:
                    break;

            }
        }
        System.out.println("程序退出成功");
    }
}



