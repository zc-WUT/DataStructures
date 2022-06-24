package com.stack;

public class Test {
    public static void main(String[] args) {
        char[][] board = new char[3][4];
        board[0][0] = 'A';
        board[0][1] = 'B';
        board[0][2] = 'C';
        board[0][3] = 'E';
        board[1][0] = 'S';
        board[1][1] = 'F';
        board[1][2] = 'C';
        board[1][3] = 'S';
        board[2][0] = 'A';
        board[2][1] = 'D';
        board[2][2] = 'E';
        board[2][3] = 'E';


        Test test = new Test();
        boolean a = test.exist(board, "ABCCED");
        System.out.println(a);

    }

    public boolean exist(char[][] board, String word) {
        int s =33; //标记，表示几个取出的数
        int index = 0; //字符串指针，表示现在取到word的哪一位
        int num = 0;//表示有几个字符满足条件
        char ch = ' '; //index所指的字符
        int a = board.length + 2;
        int b = 0;
        for (char[] c : board) {
            b = c.length + 2;
        }

        //创建一个新的二维字符组，接收board，board外面一圈的值默认为' ' bvnn vbnbv
        //将board拷贝给newBoard
        char[][] newBoard = new char[a][b];
        for (int i = 0; i < a - 2; i++) {
            for (int j = 0; j < b - 2; j++) {
                newBoard[i + 1][j + 1] = board[i][j];
            }
        }

        //遍历newBoard
        while (true) {
            //如果index已经走完，跳出循环;
            if (index == word.length()) {
                break;
            }
            ch = word.substring(index, index + 1).charAt(0);
            //如果是第一个数，直接进行比较，找到符合条件的字符后,将该位置字符变成'0',退出循环,进行下一个字符的比较
            if (index == 0) {
                first:
                for (int k = 1; k < a; k++) {
                    second:
                    for (int l = 1; l < b; l++) {
                        if (newBoard[k][l] == ch) {
                            newBoard[k][l] = (char)s;
                            s++;
                            num++;
                            break first;
                        }
                    }
                }
            }
            //如果不是第一个数,看看能否找到对应的字符，找得到，看看上下左右有没有'0'存在，有则将该处字符变为'0'，进入下一个字符的比较
            if (index != 0) {
                first:
                for (int k = 1; k < a; k++) {
                    second:
                    for (int l = 1; l < b; l++) {
                        if (newBoard[k][l] == ch) {
                            if (newBoard[k - 1][l] == (char)(s-1) || newBoard[k][l - 1] == (char)(s-1) || newBoard[k + 1][l] == (char)(s-1) || newBoard[k][l + 1] == (char)(s-1)) {
                                newBoard[k][l] = (char)s;
                                s++;
                                num++;
                                break first;
                            }
                        }
                    }
                }
            }


            index++;
        }
        if (num == word.length()) {
            return true;
        } else {
            return false;
        }
    }
}
