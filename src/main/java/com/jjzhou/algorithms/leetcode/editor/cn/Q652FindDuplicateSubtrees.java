//给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
//
// 两棵树重复是指它们具有相同的结构以及相同的结点值。
//
// 示例 1：
//
//         1
//       / \
//      2   3
//     /   / \
//    4   2   4
//       /
//      4
//
//
// 下面是两个重复的子树：
//
//       2
//     /
//    4
//
//
// 和
//
//     4
//
//
// 因此，你需要以列表的形式返回上述重复子树的根结点。
// Related Topics 树
// 👍 187 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q652FindDuplicateSubtrees {

    public static void main(String[] args) {
       Solution solution = new Q652FindDuplicateSubtrees().new Solution();

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

    // key -> subTree value -> frequency
    private Map<String, Integer> memo = new HashMap<>();
    private List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        travel(root);
        return res;
    }

    // 返回值是序列化后的子树
    private String travel(TreeNode root) {
        if (null == root) {
            return "#";
        }
        String left = travel(root.left);
        String right = travel(root.right);
        String subTree = String.format("%s,%s,%d", left, right, root.val);
        Integer frequency = memo.getOrDefault(subTree, 0);
        if (frequency == 1) {
            res.add(root);
        }
        memo.put(subTree, frequency + 1);
        return subTree;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
