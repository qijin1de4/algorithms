package me.hqj.algorithms.common;

/**
 * 二叉树节点
 * @param <T>
 */
public class DoubleLinkNode<T> {

    private T data = null;

    private DoubleLinkNode<T> left = null;

    private DoubleLinkNode<T> right = null;

    public DoubleLinkNode(T data) {
        this.data = data;
    }

    public DoubleLinkNode(T data, DoubleLinkNode<T> l, DoubleLinkNode<T> r) {
        this.data  = data;
        this.left = l;
        this.right = r;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DoubleLinkNode<T> getLeft() {
        return left;
    }

    public void setLeft(DoubleLinkNode<T> left) {
        this.left = left;
    }

    public DoubleLinkNode<T> getRight() {
        return right;
    }

    public void setRight(DoubleLinkNode<T> right) {
        this.right = right;
    }
}
