package me.hqj.algorithms.tree;

import me.hqj.algorithms.common.DoubleLinkNode;

public class BinaryTreeOps {

    /**
     * 二叉树先序遍历
     */
    public static <T> void dlr(DoubleLinkNode<T> root) {
        if(root != null) {
            System.out.print(root.getData() + ",");
            dlr(root.getLeft());
            dlr(root.getRight());
        }
    }

    /**
     * 二叉树中序遍历
     */
    public static <T> void ldr(DoubleLinkNode<T> root) {
        if(root != null) {
            ldr(root.getLeft());
            System.out.print(root.getData() + ",");
            ldr(root.getRight());
        }
    }

    /**
     * 二叉树后序遍历
     */
    public static <T> void lrd(DoubleLinkNode<T> root) {
        if(root != null) {
            lrd(root.getLeft());
            lrd(root.getRight());
            System.out.print(root.getData() + ",");
        }
    }

    /**
     * 将数组表示的完全二叉树转化为链表表示的树
     * @param arr
     * @return
     */
    public static <T> DoubleLinkNode<T> arrTree2LinkedTree(T[] arr) {
        if(arr != null && arr.length > 0) {

            DoubleLinkNode<T>[] refArr = new DoubleLinkNode[arr.length];

            refArr[0] = new DoubleLinkNode<>(arr[0]);

            for(int i = 2; i <= arr.length; i++) {
                if(arr[i-1] != null) {
                    refArr[i-1] = new DoubleLinkNode<>(arr[i-1]);
                    int j = i/2;
                    if( i - 2*j > 0) {
                        refArr[j-1].setRight(refArr[i-1]);
                    } else {
                        refArr[j-1].setLeft(refArr[i-1]);
                    }
                }
            }
            return refArr[0];
        }
        return null;
    }


    /**
     * 将整数数组（不包含重复元素）按照二叉排序树链式存储
     * @param <T>
     */
    public static <T extends Comparable<T>> DoubleLinkNode<T> getBinarySearchTree(T[] arr) {
        if(arr != null && arr.length > 0) {
            DoubleLinkNode<T> root = new DoubleLinkNode<>(arr[0]);
            for(int i = 1; i < arr.length; i++) {
                add2BinarySearchTree(root, arr[i]);
            }
            return root;
        }
        return null;
    }

    /**
     * 递归构建链式二叉排序树
     * @param node
     * @param val
     * @param <T>
     */
    private static <T extends Comparable<T>> void add2BinarySearchTree(DoubleLinkNode<T> node, T val) {
        if(node != null) {
          if(val.compareTo(node.getData()) > 0) {
              add2BinarySearchTree(node.getLeft(), val);
              if(node.getLeft() == null) {
                  node.setLeft(new DoubleLinkNode<>(val));
              }
          } else if(val.compareTo(node.getData()) < 0) {
              add2BinarySearchTree(node.getRight(), val);
              if(node.getRight() == null) {
                  node.setRight(new DoubleLinkNode<>(val));
              }
          }
        }
    }
}
