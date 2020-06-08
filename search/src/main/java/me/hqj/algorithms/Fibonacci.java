package me.hqj.algorithms;

/**
 * @description:
 * @author: huqijin
 * @date: 2020-06-08 15:30
 * @version: 1.0
 */
public class Fibonacci {

    /**
     * 获取第order位的Fibonaci数列数
     * @param order
     * @return
     */
    static public long getNumber(long order){
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
    static public long[] getSequence(int length){
        long[] seqArr = new long[length];
        for(int i = 0; i < length; i++){
            seqArr[i] = getNumber(i+1);
        }
        return seqArr;
    }

}
