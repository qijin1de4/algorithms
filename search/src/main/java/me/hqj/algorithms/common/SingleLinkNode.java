package me.hqj.algorithms.common;

/**
 * 单向链表节点
 */
public class SingleLinkNode<T> {

    private T val;

    private SingleLinkNode<T> next = null;

    public SingleLinkNode() {}

    public SingleLinkNode(T val) {
        this.val = val;
    }

    public SingleLinkNode(T val, SingleLinkNode<T> next) {
        this.val = val;
        this.next = next;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public SingleLinkNode<T> getNext() {
        return next;
    }

    public void setNext(SingleLinkNode<T> next) {
        this.next = next;
    }
}
