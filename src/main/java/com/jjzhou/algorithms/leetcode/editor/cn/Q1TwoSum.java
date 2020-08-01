//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
//
//
//
// 示例:
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
//
// Related Topics 数组 哈希表
// 👍 8785 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q1TwoSum {

    public static void main(String[] args) {
       Solution solution = new Q1TwoSum().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (Objects.isNull(nums)) {
            return null;
        }
        Map<Integer, Integer> valueAndIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            valueAndIndexMap.put(nums[i], i);
        }
        int[] res = new int[2];
        int mapValue;
        for (int i = 0; i < nums.length; i ++) {
            if (valueAndIndexMap.containsKey(target - nums[i]) && (mapValue = valueAndIndexMap.get(target - nums[i])) != i)  {
                res[0] = i;
                res[1] = mapValue;
                break;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
