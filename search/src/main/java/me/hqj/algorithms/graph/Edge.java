package me.hqj.algorithms.graph;

/**
 * 无向图的一条边
 */
public class Edge<T> {

    private T weight;

    /**
     * 边的起点在定点数组中的下标
     */
    private int from;

    /**
     * 边的终点在定点数组中的下标
     */
    private int to;

    Edge(T weight, int to) {
        this.weight = weight;
        this.to = to;
    }

    Edge(T weight, int from, int to) {
        this.weight = weight;
        this.to = to;
        this.from = from;
    }

    public T getWeight() {
        return weight;
    }

    public void setWeight(T weight) {
        this.weight = weight;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }
}
