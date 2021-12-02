package me.hqj.algorithms.common;

/**
 * 单向链表节点
 */
public class SingleNode<T> {

    private T val;

    private SingleNode<T> next = null;

    public SingleNode() {}

    public SingleNode(T val) {
        this.val = val;
    }

    public SingleNode(T val, SingleNode<T> next) {
        this.val = val;
        this.next = next;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public SingleNode<T> getNext() {
        return next;
    }

    public void setNext(SingleNode<T> next) {
        this.next = next;
    }
}
