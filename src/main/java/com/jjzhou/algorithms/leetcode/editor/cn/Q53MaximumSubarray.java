//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
//
// 示例:
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
//
//
// 进阶:
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
// Related Topics 数组 分治算法 动态规划
// 👍 2238 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Objects;

public class Q53MaximumSubarray {

    public static void main(String[] args) {
       Solution solution = new Q53MaximumSubarray().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 思路：
     * f(i) 表示以数字nums[i]结尾的的子数组最大和
     * f(i) = max(nums[i], f(i - 1) + nums[i])
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (Objects.isNull(nums)) {
            return 0;
        }
        int[] f = new int[nums.length];
        Arrays.fill(f, 0);
        f[0] = nums[0];
        for (int i = 1, len = nums.length; i < len; i ++) {
            f[i] = Math.max(nums[i], f[i - 1] + nums[i]);
        }
        return Arrays.stream(f).max().getAsInt();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
