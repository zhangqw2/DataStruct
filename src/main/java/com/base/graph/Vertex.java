package com.base.graph;

import com.base.iterator.Iterator;
import com.base.node.LinkedList;
import com.base.node.LinkedListDLNode;
import com.base.node.Node;


public class Vertex {
    /**
     * 顶点信息
     */
    private Object info;
    /**
     * 顶点的邻接边表
     */
    private LinkedList adjacentEdges;
    /**
     * 顶点的逆邻接边表
     */
    private LinkedList reAdjacentEdges;
    /**
     * 访问状态
     */
    private boolean visited;
    /**
     * 顶点在顶点表中的位置
     */
    private Node vexPosition;
    /**
     * 顶点所在图的类型
     */
    private int graphType;
    /**
     * 应用，如求最短路径时为Path，求关键路径时为Vtime
     */
    private Object application;

    public Vertex(Graph g,Object info){
        this.info = info;
        adjacentEdges = new LinkedListDLNode();
        reAdjacentEdges = new LinkedListDLNode();
        visited = false;
        graphType = g.getType();
        vexPosition = g.insert(this);
        application = null;
    }

    /**
     * 辅助方法:判断顶点所在图的类型
     * @return
     */
    private boolean isUnDiGraphNode(){
        return graphType==Graph.UN_DIRECTED_GRAPH;
    }

    /**
     * 获取顶点信息
     * @return
     */
    public Object getInfo(){
        return info;
    }

    /**
     * 设置顶点信息
     * @param obj
     */
    public void setInfo(Object obj){
        this.info = info;
    }

    /**
     * 与顶点的度相关的方法
     * @return
     */
    public int getDeg(){
        if(isUnDiGraphNode()){

             //无向图顶点的度为邻接边表规模

            return adjacentEdges.getSize();
        }else{
            //有向图顶点的度为出度与入度之和
            return getInDeg()+getOutDeg();
        }
    }
    public int getOutDeg(){
        //有无向图顶点的出度为邻接表规模
        return adjacentEdges.getSize();
    }
    public int getInDeg(){
        if(isUnDiGraphNode()){
            //无向图顶点的入度就是它的度
            return adjacentEdges.getSize();
        }else {
            //有向图顶点的入度为逆邻接表的规模
            return reAdjacentEdges.getSize();
        }
    }

    /**
     * 获取与顶点关联的边
     * @return
     */
    public LinkedList getAdjacentEdges(){return  adjacentEdges;}
    public LinkedList getReAdjacentEdges(){
        if(isUnDiGraphNode()){
            //无向图顶点的逆邻接边表就是其邻接边表
            return adjacentEdges;
        }else {
            return reAdjacentEdges;
        }
    }

    /**
     * 取顶点在所属图顶点集中的位置
     * @return
     */
    public Node getVexPosition(){
        return vexPosition;
    }

    /**
     * 与顶点访问状态相关方法
     * @return
     */
    public boolean isVisited(){
        return visited;
    }
    public void setToVisited(){visited = true;}
    public void setToUnVisited(){visited = false;}

    /**
     * 取或设置顶点应用信息
     * @return
     */
    protected Object getAppObj(){
        return application;
    }
    protected void setAppObj(Object app){
        application =app;
    }

    /**
     * 重置顶点状态信息
     */
    public void resetStatus(){
        visited =false;
        application = null;
    }


}
