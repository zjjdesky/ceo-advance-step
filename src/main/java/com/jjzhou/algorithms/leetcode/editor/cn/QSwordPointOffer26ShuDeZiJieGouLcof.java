//输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
//
// B是A的子结构， 即 A中有出现和B相同的结构和节点值。
//
// 例如:
//给定的树 A:
//
// 3
// / \
// 4 5
// / \
// 1 2
//给定的树 B：
//
// 4
// /
// 1
//返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
//
// 示例 1：
//
// 输入：A = [1,2,3], B = [3,1]
//输出：false
//
//
// 示例 2：
//
// 输入：A = [3,4,5,1,2], B = [4,1]
//输出：true
//
// 限制：
//
// 0 <= 节点个数 <= 10000
// Related Topics 树
// 👍 153 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

public class QSwordPointOffer26ShuDeZiJieGouLcof {

    public static void main(String[] args) {
       Solution solution = new QSwordPointOffer26ShuDeZiJieGouLcof().new Solution();

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
    /**
     * 1. 遍历A节点，首先找到值相同的节点
     * 2. 然后判断是否是子结构，如果不是，继续招下个值相同的节点
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (null != A && null != B) {
            if (A.val == B.val && isContains(A, B)) {
                return true;
            }
            if (isSubStructure(A.left, B)) {
                return true;
            }
            if (isSubStructure(A.right, B)) {
                return true;
            }
        }
        return false;
    }

    private boolean isContains(TreeNode a, TreeNode b) {
        if (null == b) {
            return true;
        }
        if (null == a) {
            return false;
        }
        if (a.val != b.val) {
            return false;
        }
        return isContains(a.left, b.left) && isContains(a.right, b.right);
    }

}
//leetcode submit region end(Prohibit modification and deletion)


}
