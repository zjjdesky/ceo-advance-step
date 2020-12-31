//给定一个二叉树，返回所有从根节点到叶子节点的路径。
//
// 说明: 叶子节点是指没有子节点的节点。
//
// 示例:
//
// 输入:
//
//   1
// /   \
//2     3
// \
//  5
//
//输出: ["1->2->5", "1->3"]
//
//解释: 所有根节点到叶子节点的路径为: 1->2->5, 1->3
// Related Topics 树 深度优先搜索
// 👍 415 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Q257BinaryTreePaths {

    public static void main(String[] args) {
       Solution solution = new Q257BinaryTreePaths().new Solution();

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        if (null == root) {
            return ans;
        }
        LinkedList<Integer> path = new LinkedList<>();
        binaryTreePaths(root, path, ans);
        return ans;
    }

    private void binaryTreePaths(TreeNode root, LinkedList<Integer> path, List<String> ans) {
        if (null == root) {
            return;
        }
        path.add(root.val);
        if (null == root.left && null == root.right) {
            ans.add(getPathStr(path));
            return;
        }

        if (null != root.left) {
            binaryTreePaths(root.left, path, ans);
            path.removeLast();
        }

        if (null != root.right) {
            binaryTreePaths(root.right, path, ans);
            path.removeLast();
        }
    }

    private String getPathStr(LinkedList<Integer> path) {
        return path.stream().map(String::valueOf).collect(Collectors.joining("->"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
