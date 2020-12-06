//给定一个二叉树，判断它是否是高度平衡的二叉树。
//
// 本题中，一棵高度平衡二叉树定义为：
//
//
// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
//
//
//
//
// 示例 1：
//
//
//输入：root = [3,9,20,null,null,15,7]
//输出：true
//
//
// 示例 2：
//
//
//输入：root = [1,2,2,3,3,null,null,4,4]
//输出：false
//
//
// 示例 3：
//
//
//输入：root = []
//输出：true
//
//
//
//
// 提示：
//
//
// 树中的节点数在范围 [0, 5000] 内
// -104 <= Node.val <= 104
//
// Related Topics 树 深度优先搜索
// 👍 530 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class Q110BalancedBinaryTree {

    public static void main(String[] args) {
       Solution solution = new Q110BalancedBinaryTree().new Solution();

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
 }

//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private Map<TreeNode, Integer> depthMap = new HashMap<>();
    public boolean isBalanced(TreeNode root) {
        if (null == root) {
            return true;
        }
        travel(root);
        int leftDepth = depthMap.getOrDefault(root.left, 0);
        int rightDepth = depthMap.getOrDefault(root.right, 0);
        int diff = leftDepth - rightDepth;
        if (diff > 1 || diff < -1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int travel(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = travel(root.left);
        int right = travel(root.right);
        if (null != root.left) {
            depthMap.put(root.left, left);
        }
        if (null != root.right) {
            depthMap.put(root.right, right);
        }
        return Math.max(left, right) + 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
