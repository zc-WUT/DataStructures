package com.algorithm;

import java.util.Arrays;

public class PrimAlgorithm {
    public static void main(String[] args) {
        char[] data = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int verxs = data.length;
        //邻接矩阵的关系使用二维数组表示
        int[][] weight = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000},};
        MGraph graph = new MGraph(verxs);
        MinTree minTree = new MinTree();
        minTree.createGaraph(graph, verxs, data, weight);
        minTree.show(graph);
        minTree.prim(graph,3);
    }

}

//创建最小生成树
class MinTree {
    /**
     * @param graph  图对象
     * @param verxs  图对应的顶点个数
     * @param data   图的各个顶点的值
     * @param weight 图的邻接矩阵
     */
    public void createGaraph(MGraph graph, int verxs, char[] data, int[][] weight) {
        int i, j;
        for (i = 0; i < verxs; i++) {//顶点
            graph.data[i] = data[i];
            for (j = 0; j < verxs; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    /**
     *编写prim算法，得到最小生成树
     * @param graph 图
     * @param v 表示从图的第几个顶点开始生成 'A'->0   'B'->1
     */
    public void prim(MGraph graph,int v){
        //visited[] 标记节点是否被访问过
        int[] visited=new int[graph.verxs];
        //visited[] 默认元素的值都是0，表示没有访问过
        //把当前节点标记为已经访问
        visited[v]=1;
        //h1和h2记录两个顶点的下标
        int h1=-1;
        int h2=-1;
        int len=0;
        int minWeight=10000;
        for (int k=1;k<graph.verxs;k++){ //如果有n个顶点，则有n-1条边
            minWeight=10000;
            //这个是确定每一次生成的子图 ，和哪个结点的距离最近
            for (int i=0;i<graph.verxs;i++){
                for (int j = 0; j < graph.verxs; j++) {
                    if (visited[i]==1&&visited[j]==0&&graph.weight[i][j]<minWeight){
                        //替换minWeight(寻找已经访问过的结点和未访问过的结点间的权值最小的边)
                        minWeight=graph.weight[i][j];
                        h1=i;
                        h2=j;
                    }
                }
            }
            len+=minWeight;
            //找到一条边是最小的
            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + "> 权值:" + minWeight);
            //将当前这个结点标记为已经访问
            visited[h2] = 1;
        }
        System.out.println("总长："+len);
    }

    public void show(MGraph graph) {
        for (int[] ints : graph.weight) {
            System.out.println(Arrays.toString(ints));
        }
    }
}

class MGraph {
    int verxs; //表示图节点的个数
    char[] data; //存放节点数据
    int[][] weight;//存放边，就是我们的邻接矩阵

    public MGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }
}
