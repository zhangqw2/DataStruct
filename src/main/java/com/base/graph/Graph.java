package com.base.graph;

import com.base.exception.Unsupportedoperation;
import com.base.iterator.Iterator;
import com.base.node.Node;
import com.sun.javafx.geom.Edge;


public interface Graph {
    /**
     * 无向图
     */
    public static final int UN_DIRECTED_GRAPH  = 0;
    /**
     * 有向图
     */
    public static final int DirectedGraph = 1;
    /**
     * 返回图的类型
     * @return
     */
    public int getType();

    /**
     * 返回图的顶点数
     * @return
     */
    public int getVexNum();

    /**
     * 返回图的边数
     * @return
     */
    public int getEdgeNum();

    /**
     * 返回图的所有顶点
     * @return
     */
    public Iterator getVertex();

    /**
     * 返回图的所有边
     * @return
     */
    public Iterator getEdge();

    /**
     * 删除一个顶点v
     * @param v
     */
    public void remove(Vertex v);

    /**
     * 删除一条边
     * @param e
     */
    public void remove(Edge e);

    /**
     * 添加一个顶点v
     * @param v
     * @return
     */
    public Node insert(Vertex v);

    /**
     * 添加一条边e
     * @param e
     * @return
     */
    public Node insert(Edge e);

    /**
     * 判断顶点u,v是否邻接，即是否有边从u到v
     * @param u
     * @param v
     * @return
     */
    public boolean areAdjacent(Vertex u,Vertex v);

    /**
     * 返回从u指向v的边，不存在则返回null
     * @param u
     * @param v
     * @return
     */
    public Edge edgeFromTo(Vertex u,Vertex v);

    /**
     * 对图进行深度优先遍历
     * @param v
     * @return
     */
    public Iterator DFSTraverse(Vertex v);

    /**
     * 对图进行广度优先遍历
     * @param v
     * @return
     */
    public Iterator BFSTraverse(Vertex v);

    /**
     * 求顶点v到其他顶点的最短路径
     * @param v
     * @return
     */
    public Iterator shortestPath(Vertex v);

    /**
     * 求无向图的最小生成树，如果是有向图不支持此操作
     * @throws Unsupportedoperation
     */
    public void generateMST() throws Unsupportedoperation;

    /**
     * 求有向图的拓补序列，无向图不支持此操作
     * @return
     * @throws Unsupportedoperation
     */
    public Iterator toplogicalSort() throws Unsupportedoperation;

    /**
     * 求有向图无环图的关键路径，无向图不支持此操作
     * @throws Unsupportedoperation
     */
    public void criticalPath() throws Unsupportedoperation;
}
