package me.hqj.algorithms.math.impl;

import me.hqj.algorithms.math.Fibonacci;

import java.util.stream.LongStream;

/**
 * @description:
 * @author: huqijin
 * @date: 2020-06-08 15:30
 * @version: 1.0
 */
public class RecursiveFibonacci implements Fibonacci {

    /**
     * 获取第order位的Fibonaci数列数
     * @param order
     * @return
     */
    public long getNumber(long order){
        long current = order;
        if(current - 2  > 0){
            return getNumber(current -1) + getNumber(current -2);
        }else {
            return 1;
        }
    }

    /**
     * 获取长度为length的斐波那契数列
     */
    public long[] getSequence(int length){
        long[] seqArr = new long[length];

        LongStream.rangeClosed(1,length).mapToInt(order -> Integer.valueOf(Long.toString(order)) )
                .forEachOrdered( order -> seqArr[order -1] = getNumber(order) );

        return seqArr;
    }

}
