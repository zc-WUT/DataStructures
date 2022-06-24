package com.graph;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Graph {
    private List<String> vertexList; //存储顶点集合,这个没啥用，只是为了查找
    private int[][] edges; //存储图对应的临结矩阵
    private int numOfEdges; //表示边的数目
    //定义数组，记录某个节点是否被访问过
    private boolean[] isVisited;

    public static void main(String[] args) {
        //测试图是否创建成功
        int n = 5;
        String[] vertexValue = {"A", "B", "C", "D", "E"};
        //创建图
        Graph graph = new Graph(n);
        //添加顶点
        for (String s : vertexValue) {
            graph.insertVertex(s);
        }
        //添加边
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.showGraph();
        graph.bfs();


    }

    public Graph(int n) {
        //初始化矩阵和vertexList
        edges = new int[n][n];
        vertexList = new ArrayList<>(n);
        numOfEdges = 0;
        isVisited = new boolean[n];
    }

    //得到第一个临接节点的下标w
    public int geiFirstNeighbor(int idx) {
        for (int j = 0; j < vertexList.size(); j++) {
            if (edges[idx][j] > 0) {
                return j;
            }
        }
        return -1;
    }

    //根据前一个临接节点的下标来获取下一个节点
    public int getNextNeighbor(int v1,int v2){
        for (int j=v2+1;j<vertexList.size();j++){
            if (edges[v1][j]>0){
                return j;
            }
        }
        return -1;
    }

    //深度优先遍历
    public void dfs(boolean[] isVisited,int i){
        //首先访问该节点，输出
        System.out.print(getValueByIndex(i)+"-->");
        isVisited[i]=true;

        int w=geiFirstNeighbor(i);
        while (w!=-1){ //说明有
            if(!isVisited[w]){
                dfs(isVisited,w);
            }else {
                //该节点已经被访问过
                w=getNextNeighbor(i,w);
            }
        }
    }

    //广度优先遍历
    public void bfs(boolean[] isVisited,int i){
        int u; //表示队列的头节点对应的下标
        int w; //邻结节点w
        //队列，节点访问的顺序
        LinkedList queue = new LinkedList<>();
        //访问节点
        System.out.print(getValueByIndex(i)+"-->");
        isVisited[i]=true;
        //将节点加入队列
        queue.addLast(i);

        while (!queue.isEmpty()){
            //取出队列的头节点下标
            u=(Integer) queue.removeFirst();
            w=geiFirstNeighbor(u);
            while (w!=-1){ //访问到下一个节点
                if (!isVisited[w]){ //没有被访问过
                    System.out.print(getValueByIndex(w)+"-->");
                    //标记已经访问
                    isVisited[w]=true;
                    //将节点加入队列
                    queue.addLast(w);
                }
                //以u为前驱点，找w后面的u的邻节点
                w=getNextNeighbor(u,w); //体现出广度优先


            }
        }
    }

    //对dfs进行重载，遍历我们所有的节点，进行dfs
    public void dfs(){
        //遍历所有的节点，进行dfs
        for (int i=0;i<getNumOfVertex();i++){
            if (!isVisited[i]){
                dfs(isVisited,i);
            }
        }
    }

    //对bfs进行重载，遍历我们所有的节点，进行bfs
    public void bfs(){
        //遍历所有的节点，进行bfs
        for (int i=0;i<getNumOfVertex();i++){
            if (!isVisited[i]){
                bfs(isVisited,i);
            }
        }
    }


    //常用方法
    //返回节点的个数
    public int getNumOfVertex() {
        return vertexList.size();
    }

    //得到边的数目
    public int getNumOfEdges() {
        return numOfEdges;
    }

    //返回下标i对应的节点
    public String getValueByIndex(int i) {
        return vertexList.get(i);
    }

    //返回v1和v2的权值
    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    //显示图对应矩阵
    public void showGraph() {
        for (int[] edge : edges) {
            System.out.print(Arrays.toString(edge));
            System.out.println();
        }

    }

    //插入结点
    public void insertVertex(String vertex) {
        vertexList.add(vertex);
    }

    //添加边

    /**
     * @param v1     点的下标
     * @param v2
     * @param weight
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}
