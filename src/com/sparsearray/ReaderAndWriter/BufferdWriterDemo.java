package com.sparsearray.ReaderAndWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferdWriterDemo {
    /**
     *特优的成员方法 newLine() 写入一个行分隔符。根据不同的操作系统，获取不同的行分隔符
     */

    public static void main(String[] args) throws IOException {
        BufferedWriter bw =new BufferedWriter(new FileWriter("D:\\idea\\DataStructures\\src\\com\\sparsearray\\BufferedWriter.txt"));
        for (int i=0;i<10;i++){
            bw.write("德玛西亚");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
