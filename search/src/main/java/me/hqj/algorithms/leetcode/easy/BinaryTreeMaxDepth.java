package me.hqj.algorithms.leetcode.easy;

/**
 * 给定一个二叉树，找出其最大深度。
 *
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 *
 * 说明: 叶子节点是指没有子节点的节点。
 *
 *
 * [3,9,20,null,null,15,7]
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
 */
public class BinaryTreeMaxDepth {

    public int maxDepth(TreeNode root) {
        if(root != null) {
            return getDepth(root, 0);
        }
        return 0;
    }

    private int getDepth(TreeNode node, int n) {
        if( node != null) {
            n++;
            int left = getDepth(node.left, n);
            int right = getDepth(node.right, n);
            return Math.max(left, right);
        }
        return n;
    }

    public static TreeNode getTree() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9, null, null);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15, null, null);
        root.right.right = new TreeNode(7, null, null);
        return root;
    }
}
