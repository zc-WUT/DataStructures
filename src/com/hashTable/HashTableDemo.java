package com.hashTable;

import java.util.Scanner;

public class HashTableDemo {
    public static void main(String[] args) {
        HashTable hashTab = new HashTable(7);
        String key = "";
        Scanner scanner = new Scanner(System.in);

        while (true) {
            while (true) {
                System.out.println("add:  添加雇员");
                System.out.println("list: 显示雇员");
                System.out.println("find: 查找雇员");
                System.out.println("exit: 退出系统");
                key = scanner.next();
                int id;
                switch (key) {
                    case "add":
                        if (key.equals("add")) {
                            System.out.println("输入id");
                            id = scanner.nextInt();
                            System.out.println("输入名字");
                            String name = scanner.next();
                            Emp emp = new Emp(id, name);
                            hashTab.add(emp);
                        }
                        break;
                    case "exit":
                        if (key.equals("exit")) {
                            scanner.close();
                            System.exit(0);
                        }
                        break;
                    case "find":
                        System.out.println("请输入要查找的id");
                        id=scanner.nextInt();
                        hashTab.findEmpById(id);
                        break;
                    case "list":
                        if (key.equals("list")) {
                            hashTab.list();
                        }
                        break;
                }
            }
        }
    }
}

//雇员
class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

//创建HashTable，管理多条链表
class HashTable {
    private EmpLinkedList[] empLinkedLists;
    private int size;

    //构造器
    public HashTable(int size) {
        empLinkedLists = new EmpLinkedList[size];
        this.size = size;
        //不要忘了分别初始化每个链表
        for (int i = 0; i < size; i++) {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    //添加雇员
    public void add(Emp emp) {
        //根接员工的id得到该员工应当添加到哪条链表
        int empLinkedListNo = hashFunction(emp.id);
        empLinkedLists[empLinkedListNo].add(emp);


    }

    //编写散列函数，使用一个简单去模法
    public int hashFunction(int id) {
        return id % size;
    }

    //遍历hash表
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedLists[i].list(i);
        }
    }

    public void findEmpById(int id) {
        //使用散列函数判断从哪条链表查找
        int empLinkedListNo = hashFunction(id);
        Emp emp = empLinkedLists[empLinkedListNo].findEmpById(id);
        if (emp != null) {
            System.out.println("在第" + empLinkedListNo + "条链表中找到该雇员 id:" + id+"   姓名："+emp.name);
        } else {
            System.out.println("没有找到该雇员信息");
        }
    }
}

//创建EmpLinkedList链表，用于存储每一个Emp对象
class EmpLinkedList {
    private Emp head;

    //添加雇员到列表
    //说明
    //1.假定添加雇员时，id是自增长的，即id的分配总是从小到大
    //  因此我们将该雇员直接加入到本链表的最后即可
    public void add(Emp emp) {
        if (head == null) {
            head = emp;
        } else {
            //如果不是第一个雇员，则使用一个辅助指针，帮助定位到最后
            Emp curEmp = head;
            while (true) {
                if (curEmp.next == null) {
                    break;
                }
                curEmp = curEmp.next;
            }
            curEmp.next = emp;
        }
    }

    //遍历链表的雇员信息
    public void list(int no) {
        if (head == null) {
            System.out.println("第" + no + "条链表为空");
            return;
        }
        System.out.print("第" + no + "条链表的信息为:");
        Emp curEmp = head;
        while (true) {
            System.out.print("-》员工Id：" + curEmp.id + "  员工姓名：" + curEmp.name + "-》");
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();
    }

    public Emp findEmpById(int id) {
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        Emp curEmp = head;
        while (true) {
            if (curEmp.id == id) {
                break;
            }
            if (curEmp.next == null) {
                curEmp = null;
                break;
            }
            curEmp = curEmp.next;
        }
        return curEmp;
    }
}