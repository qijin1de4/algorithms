package me.hqj.algorithms.common;

public class Stack<T> {

    private SingleLinkNode<T> head = null;

    private int size;

    public Stack() {}

    public Stack(T val) {
        this.head = new SingleLinkNode<T>(val);
        size++;
    }

    public void push(T val) {
        if(val != null) {
            head = new SingleLinkNode<T>(val, head);
            size++;
        }
    }

    public T peek() {
        return head.getVal();
    }

    public T pop() {
        SingleLinkNode<T> temp = head;
        head = head.getNext();
        size--;
        return temp.getVal();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return this.size;
    }
}
