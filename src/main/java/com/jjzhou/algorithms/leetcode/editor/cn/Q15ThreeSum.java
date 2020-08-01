//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。
//
// 注意：答案中不可以包含重复的三元组。
//
//
//
// 示例：
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
//
// Related Topics 数组 双指针


package com.jjzhou.algorithms.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Q15ThreeSum {

    public static void main(String[] args) {
       Solution solution = new Q15ThreeSum().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if (Objects.isNull(nums) || nums.length < 3) {
            return null;
        }
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int left, right, sum;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            left = i + 1;
            right = nums.length - 1;
            while (left < right) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left ++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right --;
                    }
                    left ++;
                    right --;
                } else if (sum > 0) {
                    right --;
                } else {
                    left ++;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
