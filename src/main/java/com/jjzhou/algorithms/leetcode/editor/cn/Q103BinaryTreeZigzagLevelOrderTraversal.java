//给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
//
// 例如：
//给定二叉树 [3,9,20,null,null,15,7],
//
//     3
//   / \
//  9  20
//    /  \
//   15   7
//
//
// 返回锯齿形层次遍历如下：
//
// [
//  [3],
//  [20,9],
//  [15,7]
//]
//
// Related Topics 栈 树 广度优先搜索
// 👍 302 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q103BinaryTreeZigzagLevelOrderTraversal {

    public static void main(String[] args) {
       Solution solution = new Q103BinaryTreeZigzagLevelOrderTraversal().new Solution();

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (null == root) {
            return result;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        boolean isPointRight = false;
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> levelList = new ArrayList<>();
            Stack<TreeNode> tmpStack = new Stack<TreeNode>();
            for (int i = 0; i < size; i ++) {
                TreeNode node = deque.poll();
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
                if (isPointRight) {
                    levelList.add(node.val);
                } else {
                    tmpStack.add(node);
                }
            }
            while (!tmpStack.isEmpty()) {
                levelList.add(tmpStack.pop().val);
            }
            result.add(levelList);
            isPointRight = !isPointRight;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
