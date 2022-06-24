package com.algorithm;

import java.util.Arrays;

public class Kruskal {
    private int edgeNum; //边的个数
    private char[] vertex; //顶点数组
    private int[][] matrix;//邻接矩阵
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertexs={'A','B','C','D','E','F','G'};
        int matrix[][] = {
                        /*A*//*B*//*C*//*D*//*E*//*F*//*G*/
                /*A*/ {   0,  12, INF, INF, INF,  16,  14},
                /*B*/ {  12,   0,  10, INF, INF,   7, INF},
                /*C*/ { INF,  10,   0,   3,   5,   6, INF},
                /*D*/ { INF, INF,   3,   0,   4, INF, INF},
                /*E*/ { INF, INF,   5,   4,   0,   2,   8},
                /*F*/ {  16,   7,   6, INF,   2,   0,   9},
                /*G*/ {  14, INF, INF, INF,   8,   9,   0}};

        Kruskal kruskal = new Kruskal(vertexs, matrix);
        kruskal.show();
        kruskal.DoKrusal();

    }

    //构造器
    public Kruskal(char[] vertex, int[][] matrix) {
        //初始化顶点数和边的个数
        int vlen = vertex.length;
        //初始化顶点
        this.vertex = new char[vlen];
        for (int i = 0; i < vlen; i++) {
            this.vertex[i] = vertex[i];
        }

        //初始化边,使用的是复制拷贝的方式
        this.matrix = new int[vlen][vlen];
        for (int i = 0; i < vlen; i++) {
            for (int j = 0; j < vlen; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < vlen; i++) {
            for (int j = i+1; j < vlen; j++) {
                if (this.matrix[i][j] != INF) {
                    edgeNum++;
                }
            }
        }
    }

    /**
     *
     * @param ch 传入顶点的值，比如'A'
     * @return  返回ch顶点对应的下标，找不到则返回-1
     */
    public int getPosition(char ch){
        for (int i=0;i<vertex.length;i++){
            if (vertex[i]==ch){
                return  i;
            }
        }
        return -1;
    }

    /**
     * 获取图中边，放到EData[] 数组中，后面我们需要遍历该数组
     * 通过matrix 邻接矩阵来获取
     * @return
     */
    private EData[] getEdges(){
        int idx=0;
        EData[] edges=new EData[edgeNum];
        for (int i=0;i<vertex.length;i++){
            for (int j=i+1;j<vertex.length;j++){
                if (matrix[i][j]!=INF){
                    edges[idx]=new EData(vertex[i],vertex[j],matrix[i][j]);
                    idx++;
                }
            }
        }
        return edges;
    }

    /**
     * 获取下标为i的顶点的终点，由于判断两个顶点的终点是否相同
     * @param ends 记录了各个顶点对应的终点是哪个，ends 数组是在遍历过程中，逐步形成的
     * @param i ： 表示传入的顶点对应的下标
     * @return 返回的是下标为i的顶点对应的顶点的下标
     */
    public int getEnd(int[] ends,int i){
        while (ends[i]!=0){
            i=ends[i];
        }
        return i;
    }

    public void DoKrusal(){
        int idx=0;//表示最后结果数组的索引
        int[] ends=new int[edgeNum]; //用于保存已有“最小生成树”中的每个顶点在最小生成树中的终点
        //创建结果数组。保存最后的最小生成树
        EData[] results=new EData[edgeNum];
        //获取图中所有的边的集合，一共有12条边
        EData[] edges=getEdges();
        //按照边的权值大小进行排序
        Arrays.sort(edges);
        //遍历edges数组，将边添加到最小生成树中时，判断准备加入的边是否生成了回路，如果没有，就加入
        for (int i=0;i<edgeNum;i++){
            //获取到第i条边的第一个顶点
            int p1=getPosition(edges[i].start);
            int p2=getPosition(edges[i].end);

            //获取p1这个顶点在已有的最小生成树中的终点
            int m = getEnd(ends, p1);
            //获取p2这个顶点在已有的最小生成树中的终点
            int n = getEnd(ends, p2);
            //是否构成回路
            if (m!=n){ //没有构成回路
                ends[m]=n; //设置m在“已有最小生成树”中的终点
                results[idx++]=edges[i];
            }
        }
        System.out.println("最小生成树为："+Arrays.toString(results));
    }

    //打印邻接矩阵
    public void show(){
        for (int[] ints : this.matrix) {
            for (int anInt : ints) {
                System.out.printf("%15d",anInt);
            }
            System.out.println();
        }
    }
}

//创建一个类EData,它的对象实例就表示一条边
class EData implements Comparable {
    char start; //边的起点
    char end;//边的终点
    int weight;//边的权值
    public EData(char start,char end,int weight){
        this.start=start;
        this.end=end;
        this.weight=weight;
    }
    //重写toString
    @Override
    public String toString() {
        return "EData{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }


    @Override
    public int compareTo(Object o) {
        EData oo= (EData) o;
        return this.weight-oo.weight;
    }
}
