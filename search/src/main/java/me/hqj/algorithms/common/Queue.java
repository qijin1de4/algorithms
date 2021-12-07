package me.hqj.algorithms.common;

/**
 * 队列
 */
public class Queue<T> {

    private T val;

    private int size;

    private SingleLinkNode<T> front = null;

    private SingleLinkNode<T> rear = null;

    public Queue() {}

    public Queue(T val) {
       front = new SingleLinkNode<>(val, null);
       rear = front;
       size++;
    }

    /**
     * 入列
     * @param val
     */
    public void enQueue(T val) {
       if(val != null) {
           SingleLinkNode<T> newNode = new SingleLinkNode<>(val, null);
           if(rear != null) {
               rear.setNext(newNode);
               rear = rear.getNext();
           } else {
               rear = newNode;
           }
           if(front == null) {
               front = rear;
           }
           size++;
       }
    }

    /**
     * 出队列
     * @return
     */
    public T deQueue() {
        if(!isEmpty()) {
            T t = front.getVal();
            front = front.getNext();
            size--;
            return t;
        }
        return null;
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    public T peek() {
        if(!isEmpty()) {
            return front.getVal();
        }
        return null;
    }

}
