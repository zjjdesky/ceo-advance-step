//在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
// 示例 1:
//
// 输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
//
//
// 示例 2:
//
// 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4
//
// 说明:
//
// 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
// Related Topics 堆 分治算法
// 👍 837 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q215KthLargestElementInAnArray {

    public static void main(String[] args) {
       Solution solution = new Q215KthLargestElementInAnArray().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        if (null == nums || k <= 0) {
            return 0;
        }
        List<Integer> numList = new ArrayList<>(nums.length);
        for (int i = 0, len = nums.length; i < len; i ++) {
            numList.add(nums[i]);
        }
        Collections.sort(numList);
        return numList.get(nums.length - k);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
