package me.hqj.algorithms.sort.impl;

import me.hqj.algorithms.common.Stack;
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
//               maxHeap(arr, i);
                nonRecursiveMaxHeap(arr, i);
               Sort.swap(arr, 0, i-1);
            }
        }
        return arr;
    }

    /**
     * 构造数组从下标0到下标n(n从1开始）的大顶堆(大顶堆是一棵根结点大于所有字节点的完全二叉树）
     * @param arr
     * @param n
     * @return
     */
    public void maxHeap(int[] arr, int n) {
        if(n > 1) {
            if( n % 2 == 1) { //右子节点　
                int left = n - 1 -1;
                int root = (n / 2) - 1;
                int right = n - 1;
                Sort.swap(arr, root, findLargest(arr, root, left, right));
                maxHeap(arr, n - 2);
            } else { //左子节点
                int root = ( n / 2 ) - 1;
                int left = n - 1;
                Sort.swap(arr, root, findLargest(arr, root, left));
                maxHeap(arr, n - 1);
            }
        }
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

    /**
     * 堆排序的非递归实现
     * @param arr
     * @param n
     */
    public void nonRecursiveMaxHeap(int[] arr, int n) {

        Stack<Integer> stack = new Stack<>();
        stack.push(n);

        while(!stack.isEmpty()) {
            int i = stack.pop();
            if( i > 1) {
                int root = (i / 2) - 1;
                if( i % 2 == 1) { //右子节点
                    int left = i -1 -1;
                    int right = i - 1;
                    Sort.swap(arr, root, findLargest(arr, root, left, right));
                    stack.push(i - 2);
                } else {
                    int left = i - 1;
                    Sort.swap(arr, root, findLargest(arr, root, left));
                    stack.push( i - 1);
                }
            }
        }
    }

}
