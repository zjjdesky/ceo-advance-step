//给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//给定如下二叉树，以及目标和 sum = 22，
//
//               5
//             / \
//            4   8
//           /   / \
//          11  13  4
//         /  \    / \
//        7    2  5   1
//
//
// 返回:
//
// [
//   [5,4,11,2],
//   [5,8,4,5]
//]
//
// Related Topics 树 深度优先搜索
// 👍 388 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

import java.util.*;

public class Q113PathSumIi {

    public static void main(String[] args) {
       Solution solution = new Q113PathSumIi().new Solution();
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(5, node2, node1);
        List<List<Integer>> ans = solution.pathSum(node3, 9);
        System.out.println(ans);
    }

static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
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
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (null == root) {
            return ans;
        }
        LinkedList<Integer> path = new LinkedList<>();
        pathSum(root, sum - root.val, path, ans);
        return ans;
    }

    private void pathSum(TreeNode root, int sum, LinkedList<Integer> path, List<List<Integer>> ans) {
        path.add(root.val);
        if (isLeaf(root)) {
            if (0 == sum) {
                ans.add(new ArrayList<>(path));
            }
            return;
        }
        if (null != root.left) {
            pathSum(root.left, sum - root.left.val, path, ans);
            path.removeLast();
        }
        if (null != root.right) {
            pathSum(root.right, sum - root.right.val, path, ans);
            path.removeLast();
        }
    }

    private boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
