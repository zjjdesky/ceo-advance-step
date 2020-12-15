//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
//
//
//
// 示例 1:
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
//
//
// 示例 2:
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
// Related Topics 数组 动态规划
// 👍 858 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

import java.util.*;
import java.util.stream.Stream;

public class Q152MaximumProductSubarray {

    public static void main(String[] args) {
       Solution solution = new Q152MaximumProductSubarray().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 因为存在负负得正的情况，所以只有一个最大值是推不出来的，考虑升维
     * 定义：
     *      dp[0][i] 表示在第i个数作为最后一个节点下的最大值
     *      dp[1][i] 表示在第i个数作为最后一个节点下的最小值
     * dp方程：
     *      nums[i] > 0:
     *          dp[0][i] = dp[0][i - 1] * nums[i]
     *          dp[1][i] = dp[1][i - 1] * nums[i]
     *      nums[i] < 0:
     *          dp[0][i] = dp[1][i - 1] * nums[i]
     *          dp[1][i] = dp[0][i - 1] * nums[i]
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }
        if (1 == nums.length) {
            return nums[0];
        }
        int[][] dp = new int[2][nums.length];
        dp[0][0] = nums[0];
        dp[1][0] = nums[0];
        for (int i = 1, len = nums.length; i < len; i ++) {
            dp[0][i] = getMax(dp[0][i - 1] * nums[i], nums[i], dp[1][i - 1] * nums[i]);
            dp[1][i] = getMin(dp[0][i - 1] * nums[i], nums[i], dp[1][i - 1] * nums[i]);
        }
        return getMax(dp[0]);
    }

    private int getMax(int x, int y, int z) {
        return Math.max(Math.max(x, y), z);
    }

    private int getMin(int x, int y, int z) {
        return Math.min(Math.min(x, y), z);
    }

    private int getMax(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
