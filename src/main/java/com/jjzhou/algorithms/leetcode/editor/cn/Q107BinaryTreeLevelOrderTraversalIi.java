//给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
//
// 例如：
//给定二叉树 [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其自底向上的层次遍历为：
//
// [
//  [15,7],
//  [9,20],
//  [3]
//]
//
// Related Topics 树 广度优先搜索
// 👍 373 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

import java.util.*;

public class Q107BinaryTreeLevelOrderTraversalIi {

    public static void main(String[] args) {
       Solution solution = new Q107BinaryTreeLevelOrderTraversalIi().new Solution();

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
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
class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> ansList = new LinkedList<>();
        if (null == root) {
            return ansList;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; i ++) {
                TreeNode node = deque.poll();
                levelList.add(node.val);
                if (null != node.left) {
                    deque.add(node.left);
                }
                if (null != node.right) {
                    deque.add(node.right);
                }
            }
            ansList.addFirst(levelList);
        }
        return ansList;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
