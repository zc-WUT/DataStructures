package com.algorithm;

import java.util.Arrays;

public class MyDijkstra {
    public static void main(String[] args) {
        char[] vertex = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        //邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;// 表示不可以连接
        matrix[0]=new int[]{N,5,7,N,N,N,2};
        matrix[1]=new int[]{5,N,N,9,N,N,3};
        matrix[2]=new int[]{7,N,N,N,8,N,N};
        matrix[3]=new int[]{N,9,N,N,N,4,N};
        matrix[4]=new int[]{N,N,8,N,N,5,4};
        matrix[5]=new int[]{N,N,N,4,5,N,6};
        matrix[6]=new int[]{2,3,N,N,4,6,N};
        //创建一个Graph对象
        Graph1 graph = new Graph1(vertex, matrix);
        graph.showGraph();
        graph.dsj(6);
        graph.showDijkstra();
    }
}
class Graph1{
    private char[] vertex; //顶点数组
    private  int[][] matrix;//邻接矩阵
    private VisitedVertex vv; //已经访问的顶点的集合

    //显示结果
    public void showDijkstra() {
        vv.show();
    }

    public Graph1(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    public void showGraph(){
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }

    //迪杰斯特拉算法
    /**
     *
     * @param index 表示出发顶点对应的下标
     */
    public void dsj(int index){
        vv = new VisitedVertex(vertex.length, index);
        update(index); //更新index顶点到周围顶点的距离和前驱顶点
        for (int j=1;j<vertex.length;j++){
            index=vv.updateArr();//选择并返回新的访问顶点
            update(index);//更新index顶点到周围顶点的距离和前驱顶点
        }
    }

    //更新index下标顶点到走周围顶点的距离和周围顶点的前驱节点
    public void update(int index) {
        int len = 0;
        //根据遍历我们的邻接矩阵的  matrix[index]行
        for(int j = 0; j < matrix[index].length; j++) {
            // len 含义是 : 出发顶点到index顶点的距离 + 从index顶点到j顶点的距离的和
            len = vv.getDis(index) + matrix[index][j];
            // 如果j顶点没有被访问过，并且 len 小于出发顶点到j顶点的距离，就需要更新
            if(!(vv.already_arr[j] ==1) && len < vv.getDis(j)) {
                vv.updatePre(j, index); //更新j顶点的前驱为index顶点
                vv.updateDis(j, len); //更新出发顶点到j顶点的距离
            }
        }
    }
}
