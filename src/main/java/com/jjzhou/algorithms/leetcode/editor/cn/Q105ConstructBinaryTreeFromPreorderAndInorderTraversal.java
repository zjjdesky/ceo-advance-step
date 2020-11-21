//根据一棵树的前序遍历与中序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 前序遍历 preorder = [3,9,20,15,7]
//中序遍历 inorder = [9,3,15,20,7]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
// Related Topics 树 深度优先搜索 数组
// 👍 760 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q105ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String[] args) {
       Solution solution = new Q105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (null == preorder || null == inorder || preorder.length != inorder.length) {
            return null;
        }
        Map<Integer, Integer> inMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i ++) {
            inMap.put(inorder[i], i);
        }
        int n = preorder.length;
        return buildTree(preorder, 0, n - 1, inorder, 0, n - 1, inMap);
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        int inRootIdx = inMap.get(preorder[preStart]);
        TreeNode root = new TreeNode(preorder[preStart]);
        int leftSubTreeNums = inRootIdx - inStart;
        root.left = buildTree(preorder, preStart + 1, preStart + leftSubTreeNums, inorder, inStart , inRootIdx - 1, inMap);
        root.right = buildTree(preorder, preStart + leftSubTreeNums + 1, preEnd, inorder, inRootIdx + 1, inEnd, inMap);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
