//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
//
//
//
// 示例 1:
//
// 输入: [3,2,3]
//输出: 3
//
// 示例 2:
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
//
// Related Topics 位运算 数组 分治算法
// 👍 688 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

public class Q169MajorityElement {

    public static void main(String[] args) {
       Solution solution = new Q169MajorityElement().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int major = nums[0];
        for (int i = 1, len = nums.length; i < len; i ++) {
            if (nums[i] == major) {
                count ++;
            } else {
                if (count == 0) {
                    major = nums[i];
                    count ++;
                } else {
                    count--;
                }
            }
        }
        return major;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
