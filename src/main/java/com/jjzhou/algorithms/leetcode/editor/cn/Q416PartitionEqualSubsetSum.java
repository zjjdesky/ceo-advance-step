//给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
//
// 注意:
//
//
// 每个数组中的元素不会超过 100
// 数组的大小不会超过 200
//
//
// 示例 1:
//
// 输入: [1, 5, 11, 5]
//
//输出: true
//
//解释: 数组可以分割成 [1, 5, 5] 和 [11].
//
//
//
//
// 示例 2:
//
// 输入: [1, 2, 3, 5]
//
//输出: false
//
//解释: 数组不能分割成两个元素和相等的子集.
//
//
//
// Related Topics 动态规划
// 👍 621 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

import java.util.Arrays;
import java.util.stream.Stream;

public class Q416PartitionEqualSubsetSum {

    public static void main(String[] args) {
       Solution solution = new Q416PartitionEqualSubsetSum().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * f(i, c)表示在i个物品填满容积为c的背包
     * f(i, c) = f(i - 1, c) || f(i - 1, c - w(i))
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        if (null == nums || 0 == nums.length || 1 == nums.length) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i ++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        int n = nums.length;
        int c = sum / 2;
        int[][] memo = new int[n][c + 1];
        for (int i = 0; i < n; i ++) {
            Arrays.fill(memo[i], -1);
        }
        return tryPartition(nums, n - 1, c, memo);
    }

    /**
     * 使用[0, index] 是否可以填充一个容量为sum的背包
     * @param nums
     * @param index
     * @param c
     * @return
     */
    private boolean tryPartition(int[] nums, int index, int c, int[][] memo) {
        if (c == 0) {
            return true;
        }
        if (c < 0 || index < 0) {
            return false;
        }
        if (memo[index][c] != -1) {
            return memo[index][c] == 1;
        }
        boolean isPartition = tryPartition(nums, index - 1, c, memo) || tryPartition(nums, index - 1, c - nums[index], memo);
        if (isPartition) {
            memo[index][c] = 1;
        } else {
            memo[index][c] = 0;
        }
        return isPartition;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
