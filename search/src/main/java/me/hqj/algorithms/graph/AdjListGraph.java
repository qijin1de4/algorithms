package me.hqj.algorithms.graph;

import me.hqj.algorithms.common.SingleLinkNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 邻接表矩阵图
 *  图的节点间的边（无向图）或者弧（有向图）通过邻接表表示
 */
public class AdjListGraph<T, R> {

    /**
     * 图的邻接矩阵
     * vertexes: 图的定点数组
     */
    private List<Vertex<T, Edge<R>>> vertexes;

    AdjListGraph(List<Vertex<T, Edge<R>>> vertexes) {
        this.vertexes = vertexes;
    }

    /**
     * 通过一个邻接矩阵表示的图构建邻接表表示的图
     * @param adjMatrixGraph
     */
    AdjListGraph(AdjMatrixGraph<T,R> adjMatrixGraph) {
        if(adjMatrixGraph != null
            && adjMatrixGraph.getNodes() != null && adjMatrixGraph.getNodes().length > 0
            && adjMatrixGraph.getEdges() != null && adjMatrixGraph.getEdges().length > 0) {
            T[] nodes = adjMatrixGraph.getNodes();
            R[][] edges = adjMatrixGraph.getEdges();
            vertexes = getVertexes();
            for(int i = 0; i < nodes.length; i++) {
                Vertex<T, Edge<R>> vertex = new Vertex<>(nodes[i]);
                vertexes.add(vertex);
                for(int j = 0; j < edges[i].length; j++) {
                    if(edges[i][j] != null) {
                        SingleLinkNode<Edge<R>> edge = getLastEdge(vertex);
                        if(edge == null) {
                            vertex.setEdge(new SingleLinkNode<>(new Edge<>(edges[i][j], j)));
                        } else {
                            edge.setNext(new SingleLinkNode<>(new Edge<>(edges[i][j], j)));
                        }
                    }
                }
            }
        }
    }

    private SingleLinkNode<Edge<R>> getLastEdge(Vertex<T,Edge<R>> vertex) {
        SingleLinkNode<Edge<R>> edge = vertex.getEdge();
        while(edge != null && edge.getNext() != null) {
            edge = edge.getNext();
        }
        return edge;
    }

    /**
     * 深度优先遍历
     */
    public void dfs() {

        Set<Integer> accessed = new HashSet<>();

        for(int i = 0; i < vertexes.size(); i++) {
            if(!accessed.contains(i)) {
                accessed.add(i);
                Vertex<T, Edge<R>> vertex = vertexes.get(i);
                System.out.print(vertex.getVal() + " -> ");
                SingleLinkNode<Edge<R>> edge = vertex.getEdge();
                while(edge != null) {
                    int neighborVertexIndex = edge.getVal().getTo();
                    if(!accessed.contains(neighborVertexIndex)) {
                        accessed.add(neighborVertexIndex);
                        Vertex<T, Edge<R>> neighborVertex = vertexes.get(neighborVertexIndex);
                        System.out.print(neighborVertex.getVal() + " -> ");
                        edge = edge.getNext();
                    }
                }
            }
        }
    }

    /**
     * 广度优先遍历
     */
    public void bfs() {

    }

    public List<Vertex<T, Edge<R>>> getVertexes() {
        if(vertexes == null) {
            this.vertexes = new ArrayList<>();
        }
        return vertexes;
    }

    public void setVertexes(List<Vertex<T, Edge<R>>> vertexes) {
        this.vertexes = vertexes;
    }
}
