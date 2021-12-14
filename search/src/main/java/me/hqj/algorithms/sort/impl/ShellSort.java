package me.hqj.algorithms.sort.impl;

import me.hqj.algorithms.sort.Sort;
import org.apache.commons.lang3.ArrayUtils;

/**
 * @description: 希尔排序
 *
 * 希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，每组包含的关键词越来越多，当增量减至 1 时，整个文件恰被分成一组，算法便终止。
 *
 * https://baike.baidu.com/item/%E5%B8%8C%E5%B0%94%E6%8E%92%E5%BA%8F/3229428?fr=aladdin
 * @author: huqijin
 * @date: 2020-06-20 18:54
 * @version: 1.0
 */
public class ShellSort implements Sort {

    @Override
    public int[] sort(int[] arr) {

        if(ArrayUtils.isNotEmpty(arr)) {
            for( int gap = arr.length /2 ; gap > 0; gap /=2) {
                for( int i = gap; i < arr.length; i++) {
                    int j = i;
                    int temp = arr[i];
                    for(; j - gap >=0 && arr[j-gap] > temp; j -= gap) {
                        arr[j] = arr[j-gap];
                    }
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
