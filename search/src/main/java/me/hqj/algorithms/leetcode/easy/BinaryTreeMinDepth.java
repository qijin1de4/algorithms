package me.hqj.algorithms.leetcode.easy;

/**
 * 给定一个二叉树，找出其最小深度。
 *
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 *
 * 说明：叶子节点是指没有子节点的节点。
 *
 * https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/
 */
public class BinaryTreeMinDepth {
    public int minDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int left = minDepth(root.left) + 1;
        int right = minDepth(root.right) + 1;
        return Math.min(left, right);
    }

}
