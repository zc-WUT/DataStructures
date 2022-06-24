package com.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        //完成一个中缀表达式转成后缀表达式的功能
        //说明
        //1.  1+((2+3)*4)-5 转换成 1 2 3 + 4 * + 5 -
        //2.  因为直接对str进行操作，不方便，因此 先将“1+((2+3)*4)-5” 中缀表达式对应的List
        String expression ="1+((2+3)*4)-5";

        //将表达式转换成集合，便于后面调用
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println(infixExpressionList);
        List<String> stringList = parseSuffixExpressionList(infixExpressionList);
        System.out.println(stringList);



        //先定义一个逆波兰表达式
        //String suffixExpression ="3 4 + 5 * 6 -";

        //先将suffixExpression放入一个ArrayList中
        //ArrayList传递给一个方法，遍历ArrayList配合栈完成计算
//        List<String> ls = getListString(suffixExpression);
//        int calculate = calculate(ls);
        int calculate = calculate(stringList);
        System.out.println(calculate);
    }

    /**
     * 将中缀表达式转成对应的后缀表达式
     * 步骤：
     * 1初始化两个栈：运算符栈s1和储存中间结果的栈s2；
     * 2从左至右扫描中缀表达式；
     * 3遇到操作数时，将其压s2；
     * 4遇到运算符时，比较其与s1栈顶运算符的优先级：
     * 4.1如果s1为空，或栈顶运算符为左括号“(”，则直接将此运算符入栈；
     * 4.2否则，若优先级比栈顶运算符的高，也将运算符压入s1；
     * 4.3否则，将s1栈顶的运算符弹出并压入到s2中，再次转到(4-1)与s1中新的栈顶运算符相比较；
     * 5.遇到括号时：
     * (1) 如果是左括号“(”，则直接压入s1
     * (2) 如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
     * 6.重复步骤2至5，直到表达式的最右边
     * 7.将s1中剩余的运算符依次弹出并压入s2
     * 8.依次弹出s2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
     */
    public static List<String> parseSuffixExpressionList(List<String> ls){
        //定义两个栈
        Stack<String> s1 =new Stack<>();//符号栈
        //说明：因为s2这个栈整个过程中，没有pop操作，而且后面我们还需要套逆序输出，比较麻烦，这里就使用List<String>搞定
        List<String> s2 =new ArrayList<>();//储存中间结果的栈s2

        //遍历ls
        for (String st :ls){
            //如果是一个数，加入到s2
            if (st.matches("\\d+")){
                s2.add(st);
            }else if (st.equals("(")){
                s1.push(st);
            }else if (st.equals(")")){
                //如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                s1.pop();//将（ 弹出s1栈，消除小括号
            }else {
                //现在的是字符，当字符st的优先级小于等于栈顶，将s1栈顶的运算符弹出并压入到s2中，再转到（4.1）与s1中新的栈顶进行比较
                //确少一个比较优先级高度的方法
                while (s1.size()!=0 &&Operation.getValue(s1.peek())>=Operation.getValue(st)){
                    s2.add(s1.pop());
                }
                //此时，s1为空或者st的优先级大于栈顶的运算符
                //将st压入栈
                s1.push(st);
            }
        }
        //将s1中剩余的运算符依次弹出并加入到s2
        while (s1.size()!=0){
            s2.add(s1.pop());
        }
        return s2;
    }

    //将中缀表达式转成对应的List
    public static List<String> toInfixExpressionList(String s ){
        //定义一个List，存放中缀表达式对应的内容
        List<String> ls =new ArrayList<>();
        int i=0;//相当于一个指针，遍历中缀表达式字符串;
        String str; //多位数的拼接操作
        char c;//每遍历到一个字符，就放入到c
        do {
            //如果c是一个非数字，需要加入到ls中去
            if ((c=s.charAt(i))<48||(c=s.charAt(i))>57){
                ls.add(""+c);
                i++;
            }else {
                //如果是一个数，需要考虑到多为数的问题
                str="";
                while (i<s.length()&&(c=s.charAt(i))>=48&&(c=s.charAt(i))<=57){
                    str+=c;//拼接
                    i++;
                }
                ls.add(str);
            }
        }while (i<s.length());
        return ls;
    }

    //将一个逆波兰表达式，依次将数据和运算符放入到ArrayList中
    public static List<String> getListString(String suffixExpression){
        String[] listString=suffixExpression.split(" ");
        List<String> list =new ArrayList<String>();
        for (String ele:listString){
            list.add(ele);
        }
        return list;
    }

    public static int calculate(List<String> ls){
        int num1=0;
        int num2=0;
        int res = 0;
        Stack<String> stack =new Stack<>();
        for (String l : ls) {
            //这里使用正则表达式来取出数
            if (l.matches("\\d+")){//匹配的是多位数
                //入栈
                stack.push(l);
            }else {//不是一个数
                //pop出两个数出栈
                num2=Integer.valueOf(stack.pop());
                num1=Integer.valueOf(stack.pop());
                if (l.equals("+")){
                    res=num1+num2;
                }else if (l.equals("-")){
                    res=num1-num2;
                }else if (l.equals("*")){
                    res=num1*num2;
                } else if (l.equals("/")){
                    res=num1/num2;
                }
                stack.push(String.valueOf(res));
            }
        }
        return Integer.valueOf(stack.pop());
    }
}


//编写一个类，operation 可以返回一个运算符对应的优先级
class Operation{
    private static  int ADD=1;
    private static  int SUB=1;
    private static int MUL=2;
    private static int DIV=2;

    //写一个方法，返回对应的优先数字
    public static int getValue(String operation){
        int result=0;
        switch (operation){
            case "+":
                result=ADD;
                break;
            case "-":
                result=SUB;
                break;
            case "*":
                result=MUL;
                break;
            case "/":
                result=DIV;
                break;
        }
        return result;
    }
}