package me.hqj.algorithms.leetcode.hard;

public class SingleLinkNode<T> {

    T val;

    SingleLinkNode<T> next = null;

    SingleLinkNode() {};

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

}
