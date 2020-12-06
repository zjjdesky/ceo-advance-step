package com.jjzhou.algorithms.leetcode.common.tree.binary;

/**
 * @author jjzhou
 * @date 2020/12/6 6:55 下午
 * @description
 */
public class TreeNode {

    public int val;

    public TreeNode left;

    public TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
