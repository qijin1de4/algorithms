package me.hqj.algorithms.graph;

import me.hqj.algorithms.common.SingleLinkNode;

/**
 *  图上的一个节点
 */
public class Vertex<T, R> {

    /**
     * 节点的数据
     */
    private T val = null;

    /**
     * 该节点的第一条边的指针
     */
    private SingleLinkNode<R> edge;

    public Vertex() {}

    public Vertex(T val) {
        this.val = val;
    }

    public Vertex(T val, SingleLinkNode<R> edge) {
        this.val = val;
        this.edge = edge;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public SingleLinkNode<R> getEdge() {
        return edge;
    }

    public void setEdge(SingleLinkNode<R> edge) {
        this.edge = edge;
    }
}
