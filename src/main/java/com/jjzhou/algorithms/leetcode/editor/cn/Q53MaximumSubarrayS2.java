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

import java.util.Objects;

public class Q53MaximumSubarrayS2 {

    public static void main(String[] args) {
       Solution solution = new Q53MaximumSubarrayS2().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 思路：
     * f(i) 表示以数字nums[i]结尾的的子数组最大和
     * f(i) = max(nums[i], f(i - 1) + nums[i])
     *
     * 上面的f(i)保存了所有的结果 但是实际上只需要max就可以了 可以用一个临时变量存f(i)即可
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (Objects.isNull(nums) || 0 == nums.length) {
            return 0;
        }
        int max = nums[0];
        int tmp = nums[0];
        for (int i = 1, len = nums.length; i < len; i ++) {
            tmp = Math.max(nums[i], tmp + nums[i]);
            max = Math.max(max, tmp);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
