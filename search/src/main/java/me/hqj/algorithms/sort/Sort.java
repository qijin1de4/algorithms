package me.hqj.algorithms.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: huqijin
 * @date: 2020-06-18 00:29
 * @version: 1.0
 */
public interface Sort {

    int[] sort(int[] arr);

    /**
     *  交换两个数组元素的位置
     * @param arr
     * @param i
     * @param j
     */
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int[] merge(int[] left, int[] right){
        List<Integer> list = new ArrayList();
        int lIndex = 0, rIndex = 0;
        while(lIndex < left.length &&  rIndex < right.length){
            if(left[lIndex] <= right[rIndex]){
                list.add(left[lIndex]);
                lIndex ++;
            }else{
                list.add(right[rIndex]);
                rIndex ++;
            }
        }
        while (lIndex < left.length) {
            list.add(left[lIndex]);
            lIndex++;
        }
        while(rIndex < right.length){
            list.add(right[rIndex]);
            rIndex++;
        }
        int[] result = new int[list.size()];
        for(int i = 0; i < result.length; i++){
            result[i] = list.get(i);
        }
        return result;
    }
}
