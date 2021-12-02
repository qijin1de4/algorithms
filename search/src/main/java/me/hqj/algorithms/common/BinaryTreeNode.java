package me.hqj.algorithms.common;

/**
 * 二叉树节点
 * @param <T>
 */
public class BinaryTreeNode<T> {

    private T data = null;

    private BinaryTreeNode<T> left = null;

    private BinaryTreeNode<T> right = null;

    public BinaryTreeNode(T data) {
        this.data = data;
    }

    public BinaryTreeNode(T data, BinaryTreeNode<T> l, BinaryTreeNode<T> r) {
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

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }
}
