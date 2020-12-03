//给定一个二叉树，原地将它展开为一个单链表。
//
//
//
// 例如，给定二叉树
//
//     1
//   / \
//  2   5
// / \   \
//3   4   6
//
// 将其展开为：
//
// 1
// \
//  2
//   \
//    3
//     \
//      4
//       \
//        5
//         \
//          6
// Related Topics 树 深度优先搜索
// 👍 640 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q114FlattenBinaryTreeToLinkedList {

    public static void main(String[] args) {
       Solution solution = new Q114FlattenBinaryTreeToLinkedList().new Solution();

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
class Solution {
    public void flatten(TreeNode root) {
        if (null == root) {
            return;
        }
        List<TreeNode> list = new ArrayList<>();
        preTravel(root, list);
        TreeNode pre = list.get(0), curr;
        for (int i = 1; i < list.size(); i ++) {
            curr = list.get(i);
            pre.left = null;
            pre.right = curr;

            pre = curr;
        }
    }

    private void preTravel(TreeNode root, List<TreeNode> list) {
        if (null == root) {
            return;
        }
        list.add(root);
        preTravel(root.left, list);
        preTravel(root.right, list);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
