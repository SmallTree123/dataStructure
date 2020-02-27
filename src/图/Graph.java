package 图;

import java.util.ArrayList;
import java.util.Arrays;

public class Graph {

    private ArrayList<String> vertexList;//存储定点集合
    private int[][] edges;//存储图对应的邻结矩阵
    private int numOfEdges;//表示边的数目
    //定义给数组boolean[]记录某个结点是否被访问
    private boolean[] isVisited;

    public static void main(String[] args) {
        int n=5;//结点的个数
        String verTexValue[]={"A","B","C","D","E"};
        Graph graph = new Graph(n);
        //添加顶点
        for (String vertextvalue : verTexValue) {
            graph.insertVertex(vertextvalue);
        }
        //添加边
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);

//        graph.showGraph();

        System.out.println("深度遍历");
        graph.dfs();
    }

    public Graph(int n){
        //初始化矩阵和vertexList
        edges=new int[n][n];
        vertexList=new ArrayList<>(n);
        numOfEdges=0;
        isVisited=new boolean[5];
    }

    //得到第一个邻接结点的下标
    public int getFirstNeighbor(int index){
        for (int i = 0; i < vertexList.size(); i++) {
            if (edges[index][i]>0){
                return i;
            }
        }
        return -1;
    }
    //根据前一个邻接结点的下标来获取下一个邻接结点
    public int getNextNeighbor(int v1,int v2){
        for (int i = v2+1; i < vertexList.size(); i++) {
            if (edges[v1][i]>0){
                return i;
            }

        }
        return -1;
    }

    /**
     * 深度优先遍历算法
     * @param isVisited
     * @param i
     */
    public void dfs(boolean[] isVisited,int i){
        //首先我们访问该结点，输出
        System.out.print(getValueByIndex(i)+"->");
        //将该结点设置为已经访问
        isVisited[i]=true;
        //查找结点i的第一个邻接结点w
        int w=getFirstNeighbor(i);
        while (w!=-1){ //说明有
            if (!isVisited[w]){
                dfs(isVisited,w);
            }
            //如果w结点已经被访问过
            w=getNextNeighbor(i,w);
        }

    }

    /**
     * 对dfs进行一个重载，遍历我们所有的结点
     */
    public void dfs(){
        //遍历所有的结点进行dfs[回溯]
        for (int i = 0; i < getNumOfVertex(); i++) {
            if (!isVisited[i]){
                dfs(isVisited,i);
            }

        }
    }

    //显示图对应的矩阵
    public void showGraph(){
        for (int[] link : edges) {
            System.err.println(Arrays.toString(link));
        }
    }

    //返回结点的个数
    public int getNumOfVertex() {
        return vertexList.size();
    }

    //得到边的数目
    public int getNumOfEdges(){
        return numOfEdges;
    }

    //返回结点i对应的数据0->A,1->B,2->C
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }

    //返回v1和v2的值
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }
    //插入结点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    /**
     *
     * @param v1 表示点的下标即第几个顶点A-B,A-0,B-1
     * @param v2 表示第二个顶点对应的下标
     * @param weigh
     */
    //添加边
    public void insertEdge(int v1,int v2,int weigh){
        edges[v1][v2]=weigh;
        edges[v2][v1]=weigh;
        numOfEdges++;
    }
}
