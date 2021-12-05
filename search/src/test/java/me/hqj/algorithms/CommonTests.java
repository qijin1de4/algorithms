package me.hqj.algorithms;

import me.hqj.algorithms.common.DoubleLinkNode;
import me.hqj.algorithms.tree.BinaryTreeOps;
import org.junit.Test;

public class CommonTests {

    @Test
    public void binaryTreeOpTest() {

        Integer[] fullTree = {1,2,3,4,5,6,7};

        DoubleLinkNode<Integer> root = BinaryTreeOps.arrTree2LinkedTree(fullTree);

        System.out.println("先序");

        BinaryTreeOps.dlr(root);

        System.out.println("\n中序");

        BinaryTreeOps.ldr(root);

        System.out.println("\n后序");

        BinaryTreeOps.lrd(root);

        Integer[] randomTree = {5,12,8,43,60,2,7};

        DoubleLinkNode<Integer> result = BinaryTreeOps.getBinarySearchTree(randomTree);

        System.out.println("\n二叉排序树");
        BinaryTreeOps.dlr(result);
        System.out.println("\n二叉排序树");
        BinaryTreeOps.lrd(result);
    }
}
