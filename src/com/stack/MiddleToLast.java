package com.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MiddleToLast {
    public static void main(String[] args) {
        String expression = "1+((2+3)*4)-5";
        List<String> sl = exchangeToMiddleList(expression);
        System.out.println(sl);
        List<String> stringList = meddleToLastList(sl);
        System.out.println(stringList);

    }

    public static List<String> meddleToLastList(List<String> sl) {
        Stack<String> s1 = new Stack<>();
        List<String> s2 = new ArrayList<>();
        for (String s : sl) {
            //如果是一个数，加入到s2
            if (s.matches("\\d+")) {
                s2.add(s);
            } else if (s.equals("(")) {//不是有个数,且为 (
                s1.push(s);
            } else if (s.equals(")")) {
                while (!s1.peek().equals("("))  {
                    s2.add(s1.pop());
                }
                s1.pop();
            } else {
                if (s1.size() == 0){
                    s1.push(s);
                }else if (s1.peek().equals("(")) {
                    s1.push(s);
                } else {
                    while (Operation2.getValue(s) <= Operation2.getValue(s1.peek())){
                        s2.add(s1.pop());
                        if (s1.size()==0){
                            break;
                        }
                    }
                    s1.push(s);
                }
            }
        }
        while (s1.size()!=0){
            s2.add(s1.pop());
        }
        return s2;
    }

    public static List<String> exchangeToMiddleList(String expression) {
        List<String> c = new ArrayList<>();
        String ch = "";
        String chnx = "";
        int i = 0;
        while (i < expression.length()) {
            ch = expression.substring(i, i + 1);
            if (ch.charAt(0) > 48 && ch.charAt(0) < 57) {
                while (i < expression.length() - 1) {
                    chnx = expression.substring(i + 1, i + 2);
                    if (chnx.charAt(0) < 48 || chnx.charAt(0) > 57) {
                        break;
                    }
                    ch = ch + chnx;
                    i++;
                }
                c.add(ch);
                i++;
            } else {
                c.add(ch);
                i++;
            }
        }
        return c;
    }

}

class Operation2 {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //写一个方法，返回对应的优先数字
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
        }
        return result;
    }
}