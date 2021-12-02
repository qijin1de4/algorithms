package me.hqj.algorithms;

import me.hqj.algorithms.common.BinaryTreeNode;

public class BinaryTreeOps {

    /**
     * 二叉树先序遍历
     */
    public static <T> void dlr(BinaryTreeNode<T> root) {
        if(root != null) {
            System.out.print(root.getData());
            dlr(root.getLeft());
            dlr(root.getRight());
        }
    }

    /**
     * 将数组表示的完全二叉树转化为链表表示的树
     * @param arr
     * @return
     */
    public static <T> BinaryTreeNode<T> arrTree2LinkedTree(T[] arr) {
        if(arr != null && arr.length > 0) {

            BinaryTreeNode<T>[] refArr = new BinaryTreeNode[arr.length];

            refArr[0] = new BinaryTreeNode<>(arr[0]);

            for(int i = 2; i <= arr.length; i++) {
                refArr[i-1] = new BinaryTreeNode<>(arr[i-1]);
                int j = i/2;
                if( i - 2*j > 0) {
                    refArr[j-1].setRight(refArr[i-1]);
                } else {
                    refArr[j-1].setLeft(refArr[i-1]);
                }
            }
            return refArr[0];
        }
        return null;
    }

}
