package com.base.graph;

import com.base.node.Node;

public class Edge {
    public static final int NOTMAL = 0;
    /**
     * MST边
     */
    public static final int MST = 1;
    /**
     * 关键路径中的边
     */
    public static final int CRITICAL = 2;
    /**
     * 权值
     */
    private  int weight;
    /**
     * 边的信息
     */
    private Object info;
    /**
     * 边在边表中的位置
     */
    private Node edgePosition;
    /**
     * 边的第一顶点与第二顶点
     */
    private Node firstVexPosition;
    /**
     * 在顶点表中的位置
     */
    private Node secondVexPosition;
    /**
     * 边在第一顶点的邻接边表中的位置
     */
    private Node edgeFirstPosition;
    /**
     * 在无向图中就是在两个顶点的邻接表中的位置
     */
    private Node edgeSecondPosition;
    /**
     * 边的类型
     */
    private int type;
    /**
     * 所在图的类型
     */
    private int graphType;

    public Edge(Graph g,Vertex u,Vertex v,Object info){
        this(g,u,v,info,1);
    }

    public Edge(Graph g,Vertex u,Vertex v,Object info,int weight){
        this.info = info;
        this.weight = weight;
        edgePosition = g.insert(this);
        firstVexPosition = u.getVexPosition();
        secondVexPosition = v.getVexPosition();
        type =Edge.NOTMAL;
        graphType = g.getType();
        if(graphType == Graph.UN_DIRECTED_GRAPH){
            //如果是无向图，边应当加入其两个顶点的邻接边表
            edgeFirstPosition=u.getAdjacentEdges().insertLast(this);
            edgeSecondPosition=v.getAdjacentEdges().insertLast(this);
        }else{
            //如果是有向图,边加入起始点的邻接表，终止点的逆邻接边表
            edgeFirstPosition=u.getAdjacentEdges().insertLast(this);
            edgeSecondPosition=v.getAdjacentEdges().insertLast(this);
        }
    }

    public Object getInfo(){
        return info;
    }

    public void setInfo(Object obj) {
        this.info = info;
    }
    public int getWeight(){
        return weight;
    }
    public void setWeight(int weight){
        this.weight=weight;
    }
    public Vertex getFirstVex(){
        return (Vertex)firstVexPosition.getData();
    }
    public Vertex getSecondVex(){
        return (Vertex)secondVexPosition.getData();
    }
    public Node getFirstVexPosition(){
        return firstVexPosition;
    }
    public Node getSecondVexPosition(){
        return secondVexPosition;
    }
    public Node getEdgeFirstPosition(){
        return  edgeFirstPosition;
    }
    public Node getEdgeSecondPosition(){
        return edgeSecondPosition;
    }
    public Node getEdgePosition(){
        return edgePosition;
    }

    public void setToMST(){
        type = Edge.MST;
    }
    public void setToCritical(){
        type = Edge.CRITICAL;
    }
    public void resetType(){
        type = Edge.NOTMAL;
    }
    public boolean isMSTEdge(){
        return type==Edge.MST;
    }
    public boolean isCritical(){
        return type==Edge.CRITICAL;
    }




}
