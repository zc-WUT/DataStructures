package iotest;

import org.junit.After;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;

public class WayTest {

    @Test
    public void test01() throws IOException {
        FileReader fr = null;
        try {
            File file = new File("123.txt");
            //这一步出异常可能出现 fr=null 导致 fr.close异常
            fr = new FileReader(file);
            int read;
            while ((read = fr.read()) != -1) {
                System.out.println((char) read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test02() {
        FileReader fr = null;
        try {
            File file = new File("123.txt");
            fr = new FileReader(file);
            char[] cbuffer = new char[5];
            int len;//每次char数组读取到的数据个数
            while ((len = fr.read(cbuffer)) != -1) {
                for (int i = 0; i < len; i++) {
                    System.out.print(cbuffer[i]);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fr != null) ;
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test03() {
        FileWriter fw = null;
        try {
            File file = new File("123.txt");
            fw = new FileWriter(file);
            fw.write("i love 你 , ");
            fw.write("u love me");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testCopy(){
        File file = new File("123.txt");
        File file1 = new File("124.txt");
        FileReader fr= null;
        FileWriter fw= null;
        try {
            fr = null;
            fw = null;
            fr=new FileReader(file);
            fw=new FileWriter(file1,true);
            int len;
            char[] cbuffer=new char[5];
            while((len=fr.read(cbuffer))!=-1){
                fw.write(cbuffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
