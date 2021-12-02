package me.hqj.algorithms;

import me.hqj.algorithms.common.BinaryTreeNode;
import org.junit.Test;

public class CommonTests {

    @Test
    public void binaryTreeOpTest() {

        Integer[] fullTree = {1,2,3,4,5,6,7};

        BinaryTreeNode<Integer> root = BinaryTreeOps.arrTree2LinkedTree(fullTree);

        BinaryTreeOps.dlr(root);
    }
}
