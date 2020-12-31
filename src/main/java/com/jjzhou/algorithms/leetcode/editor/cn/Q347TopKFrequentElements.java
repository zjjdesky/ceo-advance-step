//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
//
//
//
// 示例 1:
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
//
//
// 示例 2:
//
// 输入: nums = [1], k = 1
//输出: [1]
//
//
//
// 提示：
//
//
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
// 你可以按任意顺序返回答案。
//
// Related Topics 堆 哈希表
// 👍 594 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Q347TopKFrequentElements {

    public static void main(String[] args) {
       Solution solution = new Q347TopKFrequentElements().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if (null == nums || k <= 0) {
            return null;
        }
        Map<Integer, Integer> numAndCountMap = new HashMap<>();
        for (int i = 0, len = nums.length; i < len; i ++) {
            numAndCountMap.merge(nums[i], 1, Integer::sum);
        }
        int[] ans = new int[k];
        List<Integer> list = numAndCountMap.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(k)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        for (int i = 0; i < k; i ++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
