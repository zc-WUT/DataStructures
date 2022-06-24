package com.tree;

import java.io.*;
import java.util.*;

public class HuffmanCode {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
/*        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        byte[] zip = zip(contentBytes);
        System.out.println(Arrays.toString(zip) + "   长度: " + zip.length);
        byte[] decode = decode(huffmanCodes, zip);
        System.out.println(Arrays.toString(decode));
        System.out.println("解码后的字符串："+new String(decode));*/
        //测试压缩文件代码
        String fileSrc="D://3.txt";
        String saveFileSrc="D://3.zip";
        String dstFile="D://2.txt";
        zipFile(fileSrc,saveFileSrc);
        System.out.println("压缩成功");
        unZipFile(saveFileSrc,dstFile);
        System.out.println("解压成功");

    }

    public static void unZipFile(String zipFile,String dstFile) throws IOException, ClassNotFoundException {
        //定义文件输入流
        InputStream is=null;
        //定义对象输入流
        ObjectInputStream ois=null;
        //定义文件输出流
        OutputStream os=null;
        //创建文件输入流
        is=new FileInputStream(zipFile);
        //创建一个和is关联的对象输入流
        ois=new ObjectInputStream(is);
        //读取byte数组
        byte[] zipBytes = (byte[])ois.readObject();
        //读取赫夫曼编码表
        Map<Byte,String> huffmanCds=(Map<Byte,String>)ois.readObject();
        //解码
        byte[] decode = decode(huffmanCds, zipBytes);

        os=new FileOutputStream(dstFile);
        //写数据到文件中
        os.write(decode);
        os.close();
        ois.close();
        is.close();
    }


    //编写方法，将一个文件进行压缩
    public static void zipFile(String fileSrc,String saveFileSrc) throws IOException {
        //创建输出流
        //创建文件的输入流
        FileInputStream is=new FileInputStream(fileSrc);
        //创建文件输出流,存放压缩文件
        OutputStream os=new FileOutputStream(saveFileSrc);
        byte[] b=new byte[is.available()];
        //读取文件
        is.read(b);
        //获取到文件对应的huffman编码表
        byte[] zip=zip(b);
        //创建一个和文件输出流相关联的ObjectOutputStream
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(zip);
        //以对象流的方式写入赫夫曼编码，是为了以后我们回复源文件时使用,相当于用于解码的码表
        oos.writeObject(huffmanCodes);
        oos.close();
        os.close();
        is.close();



    }

    //完成数据的解压
    //1.将zip[] 重写成赫夫曼编码对应的二进制的字符串
    //2.赫夫曼编码对应的二进制字符串 ===》对照赫夫曼编码 ==》"i like like like java do you like a java"
    public static byte[] decode(Map<Byte, String> huffmanCodes, byte[] zip) {
        //先得到 zip 对应的二进制字符串
        String st = "";
        //将byte数组转成二进制字符串
        for (int i = 0; i < zip.length - 1; i++) {//只取到倒数第二位，最后一位可能需要补高位，故留在后面
            st += byteToBitString(true, zip[i]);
        }
        st += byteToBitString(false, zip[zip.length - 1]); //连接最后一位

        //对照赫夫曼编码 ==》"i like like like java do you like a java"
        //将赫夫曼编码进行key value掉换，因为需要反向查询 -88--》10101000 || 10101000 --》-88
        Map<String,Byte> map=new HashMap<>();
        for (Map.Entry<Byte,String> entry:huffmanCodes.entrySet()){
            map.put(entry.getValue(),entry.getKey());
        }

        //创建一个集合，存放byte[];
        List<Byte> list=new ArrayList<>();
        //i可以理解成一个索引
        int start=0;
        for (int i=1;i<=st.length();i++){
            while (map.get(st.substring(start,i))==null){
                i++;
            }
            list.add(map.get(st.substring(start,i)));
            start=i;
            i+=1;
        }

        //for循环结束，将list转换成集合byte[] 形式返回
        byte[] ans=new byte[list.size()];
        for (int i=0;i<ans.length;i++){
            ans[i]=list.get(i);
        }
        return ans;
    }


    /**
     * 将一个byte 转成一个二进制字符串
     *
     * @param
     * @return
     */
    public static String byteToBitString(boolean notLast, byte b) {
        //使用变量保存b
        int temp = b; //将b转换成int

        if (notLast) { //不是最后一位
            //如果是正数我们还需要补高位
            temp |= 256;  //按位与 temp=temp | 256 ===> 若temp=1, 0000 0000 0000 0000 0000 0000 0000 0001 | 0000 0000 0000 0000 0000 0001 0000 0000 = 0000 0000 0000 0001 0000 0001
        }
        String str = Integer.toBinaryString(temp); //返回的是temp对应的二进制的补码，如果是正数会出现一个问题：比如若temp=1，那么str会，只等于1，而不是00.....0001的形式，故在前面进行补高位
        if (notLast) {//不是最后一位
            //如果是正数，直接转换得到的字符串达不到八位，需要补全成八位
            return str.substring(str.length() - 8);
        } else {
            //直接返回不够八个字符长度的字符串
            return str;
        }

    }

    //编写一个总方法将，字符串转换成对应的byte[]数组，在通过byte[]数组，生成对应的集合List<Node2> nodes，通过集合nodes生成一个赫夫曼树huffmanTree
    //通过赫夫曼树huffmanTree生成赫夫曼编码表huffmanCodes，返回一个由byte[]数组按照huffmanCodes压缩后得到的新byte[]数组
    public static byte[] zip( byte[] contentBytes) {

        List<Node2> nodes = getNodes(contentBytes);
        Node2 huffmanTree = createHuffmanTree(nodes);
        getCodes(huffmanTree, "");
        String newCode = "";
        for (byte b : contentBytes) {
            newCode += huffmanCodes.get(b);
        }

        //将newCode转成byte[]
        int len;
        if (newCode.length() % 8 == 0) {
            len = newCode.length() / 8;
        } else {
            len = newCode.length() / 8 + 1;
        }
        //创建一个存储压缩后的byte数组
        byte[] huffmanCodeBytes = new byte[len];
        int idx = 0;
        for (int i = 0; i < newCode.length(); i += 8) {
            if (i + 8 > newCode.length()) {//说明剩下的字符长度不够八位了,直接取到最后一位
                huffmanCodeBytes[idx] = (byte) Integer.parseInt(newCode.substring(i), 2);
            } else {
                huffmanCodeBytes[idx] = (byte) Integer.parseInt(newCode.substring(i, i + 8), 2);
                idx++;
            }
        }
        return huffmanCodeBytes;
    }

    //生成赫夫曼树对应的赫夫曼编码
    //思路：1.将赫夫曼编码表存放在Map<Byte,String>形式
    static Map<Byte, String> huffmanCodes = new HashMap<>();
    //2.在生成赫夫曼编码时，需要取拼接路径，定义一个String，存储某个叶子节点的路径

    /**
     * 功能：将传入的node节点的所有叶子节点的赫夫曼编码得到，并放入到huffmanCodes集合中
     *
     * @param node
     * @param code 路径，往左路径为0，往右路径为1
     */
    public static void getCodes(Node2 node, String code) {
        if (node.left == null && node.right == null) {
            huffmanCodes.put(node.data, code);
            return;
        }
        if (node.left != null) {
            getCodes(node.left, code + "0");
        }
        if (node.right != null) {
            getCodes(node.right, code + "1");
        }

    }

    //创建赫夫曼树
    public static Node2 createHuffmanTree(List<Node2> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node2 left = nodes.get(0);
            Node2 right = nodes.get(1);
            //创建一颗新的二叉树，它的根节点只有权值，没有data
            Node2 parent = new Node2(null, left.weight + right.weight);
            parent.left = left;
            parent.right = right;

            //将已经处理的两颗二叉树移除
            nodes.remove(left);
            nodes.remove(right);

            //将新的二叉树加入nodes
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    /**
     * 接收字节数组
     *
     * @param bytes
     * @return
     */
    public static List<Node2> getNodes(byte[] bytes) {
        List<Node2> nodes = new ArrayList<>();

        Map<Byte, Integer> counts = new HashMap<>();
        for (byte b : bytes) {
            Integer count = counts.get(b);
            if (count == null) { //map还没有字符数据
                counts.put(b, 1);
            } else {
                counts.put(b, count + 1);
            }
        }
        //遍历map
        for (Map.Entry<Byte, Integer> entry : counts.entrySet()) {
            nodes.add(new Node2(entry.getKey(), entry.getValue()));
        }
        return nodes;
    }
}

class Node2 implements Comparable<Node2> {
    Byte data;
    int weight;
    Node2 left;
    Node2 right;

    public Node2(Byte data, int weight) {
        this.data = data;
        this.weight = weight;
    }

    //前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    @Override
    public String toString() {
        return "Node2{" +
                "data=" + data +
                ", weight=" + weight +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    @Override
    public int compareTo(Node2 o) {
        //表示从小到大的排序
        return this.weight - o.weight;
    }
}

