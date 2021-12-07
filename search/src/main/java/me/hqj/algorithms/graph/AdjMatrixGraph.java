package me.hqj.algorithms.graph;

/**
 * 邻接矩阵图
 *  图的节点间的边（无向图）或者弧（有向图）通过邻接矩阵表示
 */
public class AdjMatrixGraph<T, R> {

    /**
     * 图中节点素组
     */
    private T[] nodes;

    /**
     * 表示节点间边/弧的邻接矩阵
     */
    private R[][] edges;

    public AdjMatrixGraph(T[] nodes, R[][] edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    public T[] getNodes() {
        return nodes;
    }

    public void setNodes(T[] nodes) {
        this.nodes = nodes;
    }

    public R[][] getEdges() {
        return edges;
    }

    public void setEdges(R[][] edges) {
        this.edges = edges;
    }
}
