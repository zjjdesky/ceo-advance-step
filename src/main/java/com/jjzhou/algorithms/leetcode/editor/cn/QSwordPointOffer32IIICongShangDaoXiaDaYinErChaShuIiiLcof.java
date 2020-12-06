//请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
//
//
//
// 例如:
//给定二叉树: [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回其层次遍历结果：
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
//
//
//
//
// 提示：
//
//
// 节点总数 <= 1000
//
// Related Topics 树 广度优先搜索
// 👍 56 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

import java.util.*;

public class QSwordPointOffer32IIICongShangDaoXiaDaYinErChaShuIiiLcof {

    public static void main(String[] args) {
       Solution solution = new QSwordPointOffer32IIICongShangDaoXiaDaYinErChaShuIiiLcof().new Solution();

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (null == root) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean isPointRight = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelAns = new ArrayList<>(size);
            ans.add(levelAns);
            while (size -- > 0) {
                TreeNode node = queue.poll();
                levelAns.add(node.val);
                if (null != node.left) {
                    queue.offer(node.left);
                }
                if (null != node.right) {
                    queue.offer(node.right);
                }
            }
            if (!isPointRight) {
                Collections.reverse(levelAns);
            }
            isPointRight = !isPointRight;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
