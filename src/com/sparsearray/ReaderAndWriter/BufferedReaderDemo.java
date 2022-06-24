package com.sparsearray.ReaderAndWriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderDemo {
    /**
     * 特殊的成员方法
     * String readLine() 读取一个文本的行。读取一行数据
     * 行的中止符号：通过谢列字符之一即可认为某行中止：换行('\n'),回车('\r')或回车后直接跟着换行('\r\n')
     * 返回值：包含该行内容的字符串，不包含任何中止符，如果已经到达流末尾，则返回null
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\idea\\DataStructures\\src\\com\\sparsearray\\BufferedWriter.txt"));
/*        String s = br.readLine();
        System.out.println(s);*/
        String line = null;
        while ((line = br.readLine()) != null) {
            String[] split = line.split("\\.");
            System.out.println(split[0]);
            System.out.println(split[1]);
        }
        br.close();
    }
}
