//从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
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
//  [9,20],
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
//
// 注意：本题与主站 102 题相同：https://leetcode-cn.com/problems/binary-tree-level-order-tra
//versal/
// Related Topics 树 广度优先搜索
// 👍 66 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class QSwordPointOffer32IICongShangDaoXiaDaYinErChaShuIiLcof {

    public static void main(String[] args) {
       Solution solution = new QSwordPointOffer32IICongShangDaoXiaDaYinErChaShuIiLcof().new Solution();

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
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> levelAns = new ArrayList<>();
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
            ans.add(levelAns);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
