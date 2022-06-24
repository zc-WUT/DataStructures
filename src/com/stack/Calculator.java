package com.stack;

public class Calculator {
    public static void main(String[] args) {
        //完成表达式的运算
        String expression = "7*2*2-5+1-5+3-4";
        //创建两个栈，一个数栈，一个符号栈
        ArrayStack2 nums = new ArrayStack2(10);
        ArrayStack2 opers = new ArrayStack2(10);
        ArrayStack2 nums2 = new ArrayStack2(10);
        ArrayStack2 opers2 = new ArrayStack2(10);
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' '; //将每次扫描得到的char保存到ch
        String keepNum ="";//用于拼接多位数字
        //开始while语句循环的扫描expression
        while (true) {
            //依次得到expression的每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            //判断ch是什么，然后做相应的处理
            if (opers.isOper(ch)) {
                //判断当前符号栈是否为空
                if (opers.isEmpty()) {
                    opers.push(ch);
                } else {
                    //如果符号栈有操作符，就进行比较，如果当前的操作符的优先级小于或等于栈中的操作符，就需要从数栈中pop出两个数
                    //再从符号栈中pop出一个符号，进行运算，将得到结果，入数栈，然后将当前的操作符写入符号栈
                    if (opers.priority(ch) <= opers.priority(opers.peek())) {
                        num2 = nums.pop();
                        num1 = nums.pop();
                        oper = opers.pop();
                        res = nums.cal(num1, num2, oper);
                        //把运算结果入数栈
                        nums.push(res);
                        //当前符号入符号栈
                        opers.push(ch);
                    } else {
                        //如果符号栈有操作符，就进行比较，如果当前的操作符的优先级大于栈中的操作符，直接入符号栈
                        opers.push(ch);
                    }
                }
            } else {
                //如果是数字，则直接入数栈
//                nums.push(ch - 48); //ascii码表中char的1，等价于int的49，差了48
                //1.当处理多位数时，不能发现一个数就入栈一个数，多位数会被分开加入
                //在处理数是，需要index往后再看一位，如果是数就继续扫描，如果是符号才入栈
                //因此我们应该定义一个变量

                //处理多位数
                keepNum +=ch;

                //如果ch已经是最后一个数字，就直接入栈
                if (index==expression.length()-1) {
                    nums.push(Integer.parseInt(keepNum));
                }else
                    //判断下一个字符是不是数字，如果是数字则继续扫描
                    if (opers.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        //如果后一位是运算符，则入栈
                        nums.push(Integer.parseInt(keepNum));
                        //清空kepNum
                        keepNum = "";
                    }
            }
            index++;
            //让index+1，并判断是否扫描到expression的最后
            if (index >= expression.length()) {
                break;
            }
        }
        while (true) {
            if (nums.isEmpty()) {
                break;
            }
            nums2.push(nums.pop());
        }
        while (true) {
            if (opers.isEmpty()) {
                break;
            }
            opers2.push(opers.pop());
        }
        while (true) {
            //如果数栈中只有一个数字，则运算结束
            if (opers2.isEmpty()) {
                break;
            }
            num1 = nums2.pop();
            num2 = nums2.pop();
            oper = opers2.pop();
            res = nums.cal(num1, num2, oper);
            nums2.push(res);
        }
        System.out.printf("表达式%s的计算结果为%d", expression, nums2.pop());
    }
}

class ArrayStack2 {
    private int maxSize;
    private int[] stack;
    private int top = -1; //表示栈顶，初始化-1表示没有数据

    public ArrayStack2(int maxsize) {
        this.maxSize = maxsize;
        stack = new int[this.maxSize];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        //先判断是否满
        if (isFull()) {
            System.out.println("栈已满");
            return;
        }
        top++;
        stack[top] = value;
        System.out.println("压入" + value);
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("空栈");
            return 0;
        }
        int i = stack[top];
        System.out.println("取出" + i);

        top--;
        return i;
    }

    //查看当前的栈顶值，但是不取出
    public int peek() {
        return stack[top];
    }


    public void list() {
        if (isEmpty()) {
            System.out.println("空栈");
            return;
        }
        int lien = top;
        while (true) {
            if (lien == -1) {
                break;
            }
            System.out.println(stack[lien]);
            lien--;
        }
    }

    //返回运算符的优先级，程序员来确定
    //数字越大，则优先级越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;//表达式只有+ - * /
        }
    }

    //判断是不是一个运算符
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num1 - num2;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num1 / num2;
                break;
        }
        return res;
    }
}
