//请完成一个函数，输入一个二叉树，该函数输出它的镜像。
//
// 例如输入：
//
// 4
// / \
// 2 7
// / \ / \
//1 3 6 9
//镜像输出：
//
// 4
// / \
// 7 2
// / \ / \
//9 6 3 1
//
//
//
// 示例 1：
//
// 输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
//
//
//
//
// 限制：
//
// 0 <= 节点个数 <= 1000
//
// 注意：本题与主站 226 题相同：https://leetcode-cn.com/problems/invert-binary-tree/
// Related Topics 树
// 👍 86 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

public class QSwordPointOffer27ErChaShuDeJingXiangLcof {

    public static void main(String[] args) {
       Solution solution = new QSwordPointOffer27ErChaShuDeJingXiangLcof().new Solution();

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
    public TreeNode mirrorTree(TreeNode root) {
        if (null == root) {
            return null;
        }
        travel(root);
        return root;
    }

    private void travel(TreeNode root) {
        if (null == root) {
            return;
        }
        TreeNode tmpNode = root.left;
        root.left = root.right;
        root.right = tmpNode;
        travel(root.left);
        travel(root.right);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
