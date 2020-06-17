package me.hqj.algorithms.math;

/**
 * @description:
 * @author: huqijin
 * @date: 2020-06-18 00:24
 * @version: 1.0
 */
public interface Fibonacci {

    /**
     * 获取第order位的Fibonaci数列数
     * @param order
     * @return
     */
    long getNumber(long order);

    /**
     * 获取长度为length的斐波那契数列
     */
    long[] getSequence(int length);
}
