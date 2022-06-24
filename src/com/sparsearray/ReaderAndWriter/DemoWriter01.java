package com.sparsearray.ReaderAndWriter;

import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;

//java.io.writer :字符输出流，是所有输出流的超级抽象父类
public class DemoWriter01 {
    public static void main(String[] args) throws IOException {
        FileWriter fw =new FileWriter("D:\\idea\\DataStructures\\src\\com\\sparsearray\\b.txt");
        fw.write(97); //只是把数据写入到了内存缓冲区中，并没有写入磁盘
        fw.flush();//将内存缓存区中的数据刷新到磁盘文件中,刷新之后，流可以继续使用
        fw.write(98);
        fw.close(); //释放资源的时候，如果没有前面的flush，也会自动的将内存缓存区中的数据刷新到磁盘文件中
    }


    @Test
    public void  testTryCatch(){
        //JDK1.8对流的异常处理进行了简化：try(流对象){}catch (){}
        try (FileWriter fw =new FileWriter("null.txt")){
            fw.write(97);
            fw.flush();
        }catch (IOException e){
            System.out.println(e);
        }

    }

    @Test
    public void  testTryCatchJDK9() throws IOException {
        //jdk1.9新特性：
        /*
        *try前边可以定义流对象
        * 在tyr后边的（）中可以直接引入流对象变量
        * 在try代码指向完毕以后，流对象也可以释放，不用写finally
        * */

/*
        由于这是1.8环境，无法运行
        FileWriter fw =new FileWriter("null.txt");
        try (fw){
            fw.write(97);
        }catch (IOException e){
            System.out.println(e);
        }
*/

    }
}
