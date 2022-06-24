package iotest;

import org.junit.Test;

import java.io.*;
import java.util.Scanner;

public class BufferedTest {
    @Test
    public void test01() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            File file = new File("3.jpg");//造文件
            File file1 = new File("4.jpg");
            //造节点流
            FileInputStream fis = new FileInputStream(file);
            FileOutputStream fos = new FileOutputStream(file1);
            //造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);
            //读取与写入
            byte[] buffer = new byte[10];
            int len;
            while ((len = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源关闭：先关外层，再关内层的流
            try {
                if (bis != null)
                    bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //关闭外层流的同时，也会自动关闭内层流，因此可以i省略
        /*fis.close();
        fis.close();*/
        }
    }

    @Test
    public void test02() {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader("123.txt"));
            bw = new BufferedWriter(new FileWriter("124.txt"));

            char[] cbuf=new char[1024];
            int len;
            while ((len=br.read(cbuf))!=-1){
                bw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws IOException {
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
        String data;
        while ((data=br.readLine()).length()!=0){
            if (data.equals("exit")){
                break;
            }
            System.out.println(data);
        }
    }


    @Test
    public void test03() throws IOException {
        DataOutputStream dos=new DataOutputStream(new FileOutputStream("data.txt"));
        dos.writeUTF("张三");
        dos.writeInt(12);
        dos.writeBoolean(true);
        dos.close();
    }

    @Test
    public void test04() throws IOException {
        DataInputStream dis=new DataInputStream(new FileInputStream("data.txt"));
        String s = dis.readUTF();
        int i = dis.readInt();
        boolean b = dis.readBoolean();
        System.out.println(s);
        System.out.println(i);
        System.out.println(b);
    }
}
