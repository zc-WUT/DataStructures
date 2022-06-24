package com.algorithm;

import java.util.Arrays;

public class Floyd {
    public static void main(String[] args) {
// 测试看看图是否创建成功
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        //创建邻接矩阵
        int[][] matrix = new int[vertex.length][vertex.length];
        final int N = 65535;
        matrix[0] = new int[]{0, 5, 7, N, N, N, 2};
        matrix[1] = new int[]{5, 0, N, 9, N, N, 3};
        matrix[2] = new int[]{7, N, 0, N, 8, N, N};
        matrix[3] = new int[]{N, 9, N, 0, N, 4, N};
        matrix[4] = new int[]{N, N, 8, N, 0, 5, 4};
        matrix[5] = new int[]{N, N, N, 4, 5, 0, 6};
        matrix[6] = new int[]{2, 3, N, N, 4, 6, 0};
        Graph01 graph = new Graph01(vertex.length, matrix, vertex);
        graph.floyd();
        graph.show();
    }
}

class Graph01 {
    char[] vertex;//存放顶点数组
    int[][] dis;//保存从各个顶点出发，到其他顶点的距离
    int[][] pre;//保存到达目标顶点的前驱节点；

    //构造器

    public Graph01(int length, int[][] matrix, char[] vertex) {
        this.vertex = vertex;
        this.dis = matrix;
        this.pre = new int[length][length];
        for (int i = 0; i < length; i++) { //对pre初始化
            Arrays.fill(pre[i], i);
        }
    }

    //佛洛伊德算法
    public void floyd() {
        int len=0;//保存距离
        for (int k=0;k<dis.length;k++){

            for (int i=0;i<dis.length;i++){
                for (int j=0;j<dis.length;j++){
                    len=dis[i][k]+dis[k][j];//求从i顶底触发，经过中间顶点k，到达顶点j德距离
                    if (len<dis[i][j]){
                        dis[i][j]=len;
                        pre[i][j]=pre[k][j];
                    }
                }
            }
        }
    }

    // 显示pre数组和dis数组
    public void show() {

        //为了显示便于阅读，我们优化一下输出
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        for (int k = 0; k < dis.length; k++) {
            // 先将pre数组输出的一行
            for (int i = 0; i < dis.length; i++) {
                System.out.print(vertex[pre[k][i]] + " ");
            }
            System.out.println();
            // 输出dis数组的一行数据
            for (int i = 0; i < dis.length; i++) {
                System.out.print("(" + vertex[k] + "到" + vertex[i] + "的最短路径是" + dis[k][i] + ") ");
            }
            System.out.println();
            System.out.println();

        }

    }
}
