package me.hqj.algorithms.graph;

import me.hqj.algorithms.common.SingleLinkNode;

import java.lang.reflect.Array;

/**
 * 邻接表矩阵图
 *  图的节点间的边（无向图）或者弧（有向图）通过邻接表表示
 */
public class AdjListGraph<T, R> {

    /**
     * 图的邻接矩阵
     * vertexes: 图的定点数组
     */
    private Vertex<T,R>[] vertexes;

    AdjListGraph(Vertex<T, R>[] vertexes) {
        this.vertexes = vertexes;
    }

    /**
     * 通过一个邻接矩阵表示的图构建邻接表表示的图
     * @param adjMatrixGraph
     */
    @SuppressWarnings("unchecked")
    AdjListGraph(AdjMatrixGraph<T,R> adjMatrixGraph) {
        if(adjMatrixGraph != null
            && adjMatrixGraph.getNodes() != null && adjMatrixGraph.getNodes().length > 0
            && adjMatrixGraph.getEdges() != null && adjMatrixGraph.getEdges().length > 0) {
            T[] nodes = adjMatrixGraph.getNodes();
            R[][] edges = adjMatrixGraph.getEdges();
            vertexes = (Vertex<T, R>[]) Array.newInstance(Vertex.class, nodes.length);
            for(int i = 0; i < nodes.length; i++) {
                Vertex<T, R> vertex = new Vertex<>(nodes[i]);
                vertexes[i] = vertex;
                for(int j = 0; j < edges[i].length; j++) {
                    if(edges[i][j] != null) {
                        SingleLinkNode<R> edge = getLastEdge(vertex);
                        if(edge == null) {
                            vertex.setEdge(new SingleLinkNode<>(edges[i][j]));
                        } else {
                            edge.setNext(new SingleLinkNode<>(edges[i][j]));
                        }
                    }
                }
            }
        }
    }

    private SingleLinkNode<R> getLastEdge(Vertex<T,R> vertex) {
        SingleLinkNode<R> edge = vertex.getEdge();
        while(edge != null && edge.getNext() != null) {
            edge = edge.getNext();
        }
        return edge;
    }

    /**
     * 深度优先遍历
     */
    public void dfs() {
        for(int i = 0; i < vertexes.length; i++) {
            Vertex<T, R> vertex = vertexes[i];
            SingleLinkNode<R> edge = vertex.getEdge();
            System.out.println(" ");
            while(edge != null) {
                System.out.print(edge.getVal() + " ");
                edge = edge.getNext();
            }
        }
    }

    /**
     * 广度优先遍历
     */
    public void bfs() {

    }

    public Vertex<T, R>[] getVertexes() {
        return vertexes;
    }

    public void setVertexes(Vertex<T, R>[] vertexes) {
        this.vertexes = vertexes;
    }
}
