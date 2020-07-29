//给定一个二叉树，找出其最大深度。
//
// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例：
//给定二叉树 [3,9,20,null,null,15,7]，
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// 返回它的最大深度 3 。
// Related Topics 树 深度优先搜索


package com.jjzhou.algorithms.leetcode.editor.cn;

import java.util.Objects;

public class Q104MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
       Solution solution = new Q104MaximumDepthOfBinaryTree().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    /**
     * 思路：计算层数的时候，自底向上，最下层当做0，最上层即是层数
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        }
        int left = maxDepth(root.left) + 1;
        int right = maxDepth(root.right) + 1;
        return Math.max(left, right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
