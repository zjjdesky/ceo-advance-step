//给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
//
//
// 二叉树的根是数组中的最大元素。
// 左子树是通过数组中最大值左边部分构造出的最大二叉树。
// 右子树是通过数组中最大值右边部分构造出的最大二叉树。
//
//
// 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
//
//
//
// 示例 ：
//
// 输入：[3,2,1,6,0,5]
//输出：返回下面这棵树的根节点：
//
//      6
//    /   \
//   3     5
//    \    /
//     2  0
//       \
//        1
//
//
//
//
// 提示：
//
//
// 给定的数组的大小在 [1, 1000] 之间。
//
// Related Topics 树
// 👍 216 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

public class Q654MaximumBinaryTree {

    public static void main(String[] args) {
       Solution solution = new Q654MaximumBinaryTree().new Solution();

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

    TreeNode(int x) {
        val = x;
    }
}
class Solution {
public TreeNode constructMaximumBinaryTree(int[] nums) {
    if (null == nums || 0 == nums.length) {
        return null;
    }
    int maxValueIndex = getMaxValueIndex(nums, 0, nums.length);
    return getRootNode(nums, 0, maxValueIndex, maxValueIndex, maxValueIndex + 1, nums.length);
}

/**
 * 数组是左闭右开 [start, end)
 * @param nums
 * @param leftStart
 * @param leftEnd
 * @param rootIndex
 * @param rightStart
 * @param rightEnd
 * @return
 */
private TreeNode getRootNode(int[] nums, int leftStart, int leftEnd, int rootIndex, int rightStart, int rightEnd) {
    TreeNode root = new TreeNode(nums[rootIndex]);
    if (leftStart < leftEnd) {
        int leftMaxValueIndex = getMaxValueIndex(nums, leftStart, leftEnd);
        root.left = getRootNode(nums, leftStart, leftMaxValueIndex, leftMaxValueIndex, leftMaxValueIndex + 1, leftEnd);
    }
    if (rightStart < rightEnd) {
        int rightMaxValueIndex = getMaxValueIndex(nums, rightStart, rightEnd);
        root.right = getRootNode(nums, rightStart, rightMaxValueIndex, rightMaxValueIndex, rightMaxValueIndex + 1, rightEnd);
    }
    return root;
}

private int getMaxValueIndex(int[] nums, int start, int end) {
    assert start < end;
    int maxValueIndex = start;
    for (int i = start + 1; i < end; i ++) {
        if (nums[i] > nums[maxValueIndex]) {
            maxValueIndex = i;
        }
    }
    return maxValueIndex;
}
}
//leetcode submit region end(Prohibit modification and deletion)


}
