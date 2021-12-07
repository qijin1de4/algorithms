package me.hqj.algorithms.sort.impl;

import me.hqj.algorithms.sort.Sort;

/**
 * 堆排序
 *
 * https://www.cnblogs.com/chengxiao/p/6129630.html
 */
public class HeapSort implements Sort {

    @Override
    public int[] sort(int[] arr) {
        if(arr != null && arr.length > 1) {
            for(int i = arr.length; i > 1; i--) {
               maxHeap(arr, i, i);
               Sort.swap(arr, 0, i-1);
            }
        }
        return arr;
    }

    /**
     * 构造数组从下标0到下标n(n从1开始）的大顶堆(大顶堆是一棵根结点大于所有字节点的完全二叉树）
     * @param arr
     * @param n
     * @param limit : 未排序的数组元素界线，构建堆不能超过这个界线
     * @return
     */
    public int[] maxHeap(int[] arr, int n, int limit) {
        if( n >1 && n <= arr.length) {
            int root = n/2 -1;
            if(n%2 == 0) { //左节点
                if( n < limit) { // 界线之内
                    int left = n -1;
                    int largest = findLargest(arr, root, left, n);
                    Sort.swap(arr, root, largest);
                } else { // n位于未排序元素的最右侧边界
                    int largest = findLargest(arr, root, n-1);
                    Sort.swap(arr, root, largest);
                }
            } else { //右节点
                int left = n - 2;
                int right = n -1;
                int largest = findLargest(arr, root, left, right);
                Sort.swap(arr, root, largest);
            }
            maxHeap(arr, n - 2, limit);
        }
        return arr;
    }

    /**
     * 在数组arr的三个元素的中找到最大元素的下标
     * @param root
     * @param left
     * @param right
     * @return
     */
    public int findLargest(int[] arr, int root, int left, int right) {
        if(left < arr.length && arr[root] < arr[left]) {
            if(right < arr.length && arr[left] < arr[right]) {
                return right;
            } else {
                return left;
            }
        } else if( right < arr.length && arr[root] < arr[right]) {
            return right;
        }
        return root;
    }

    /**
     *
     * @param arr
     * @param i
     * @param j
     * @return
     */
    public int findLargest(int[] arr, int i, int j) {
       if(arr[i] == Math.max(arr[i], arr[j])) {
           return i;
       } else {
           return j;
       }
    }

}
