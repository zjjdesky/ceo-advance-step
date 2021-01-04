//输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
//
//
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
//
//
//
// 限制：
//
// 0 <= 节点个数 <= 5000
//
//
//
// 注意：本题与主站 105 题重复：https://leetcode-cn.com/problems/construct-binary-tree-from-
//preorder-and-inorder-traversal/
// Related Topics 树 递归
// 👍 283 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class QSwordPointOffer07ZhongJianErChaShuLcof {

    public static void main(String[] args) {
       Solution solution = new QSwordPointOffer07ZhongJianErChaShuLcof().new Solution();

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

    /**
     * 中序遍历的value和下标构成的map
     * key: nums[i]     value: i
     */
    private Map<Integer, Integer> inorderVarAndIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (null == preorder || null == inorder ||
                preorder.length != inorder.length || preorder.length == 0) {
            return null;
        }
        inorderVarAndIndexMap = initInorderVarAndIndexMap(inorder);
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private Map<Integer, Integer> initInorderVarAndIndexMap(int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>(inorder.length);
        for (int i = 0, len = inorder.length; i < len; i ++) {
            map.put(inorder[i], i);
        }
        return map;
    }

    private TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd | inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        Integer inorderRootIndex = inorderVarAndIndexMap.get(root.val);
        // 左边数组长度 leftSize = inorderRootIndex - inStart
        // 右边数组长度 rightSize = inEnd - inorderRootIndex
        int leftSize = inorderRootIndex - inStart;
        // preorder [root, [leftStart...leftEnd], [rightStart...rightEnd]]
        // leftStart = preStart + 1
        // leftEnd = preStart + leftSize
        // rightStart = leftEnd + 1
        // rightEnd = preEnd
        // -------------------------------------------------------------------------
        // inorder [[leftStart...leftEnd], root, [rightStart...rightEnd]]
        // leftStart = inStart
        // leftEnd = inorderRootIndex - 1
        // rightStart = inorderRootIndex + 1
        // rightEnd = inEnd
        root.left = buildTree(preorder, preStart + 1, preStart + leftSize, inorder, inStart, inorderRootIndex - 1);
        root.right = buildTree(preorder, preStart + leftSize + 1, preEnd, inorder, inorderRootIndex + 1, inEnd);
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
