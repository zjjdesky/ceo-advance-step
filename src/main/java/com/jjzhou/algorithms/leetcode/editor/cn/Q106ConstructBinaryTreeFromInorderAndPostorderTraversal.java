//根据一棵树的中序遍历与后序遍历构造二叉树。
//
// 注意:
//你可以假设树中没有重复的元素。
//
// 例如，给出
//
// 中序遍历 inorder = [9,3,15,20,7]
//后序遍历 postorder = [9,15,7,20,3]
//
// 返回如下的二叉树：
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
// Related Topics 树 深度优先搜索 数组
// 👍 418 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Q106ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public static void main(String[] args) {
       Solution solution = new Q106ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (null == inorder || null == postorder) {
            return null;
        }
        assert inorder.length == postorder.length;
        if (inorder.length == 0) {
            return null;
        }
        int length = inorder.length;
        Map<Integer, Integer> inValueAndIndexMap = new HashMap<>();
        for (int i = 0; i < length; i ++) {
            inValueAndIndexMap.put(inorder[i], i);
        }
        return buildTree(inorder, 0, length - 1, postorder, 0, length - 1, inValueAndIndexMap);
    }

    private TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, Map<Integer, Integer> inValueAndIndexMap) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        int rootVal = postorder[postEnd];
        int inIndex = inValueAndIndexMap.get(rootVal);
        TreeNode root = new TreeNode(rootVal);
        int leftSize = inIndex - inStart;
        root.left = buildTree(inorder, inStart, inIndex - 1, postorder, postStart, postStart + leftSize - 1, inValueAndIndexMap);
        root.right = buildTree(inorder, inIndex + 1, inEnd, postorder, postStart + leftSize, postEnd - 1, inValueAndIndexMap);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
