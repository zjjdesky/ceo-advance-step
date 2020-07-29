//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
// 示例:
//
// 输入: [0,1,0,3,12]
//输出: [1,3,12,0,0]
//
// 说明:
//
//
// 必须在原数组上操作，不能拷贝额外的数组。
// 尽量减少操作次数。
//
// Related Topics 数组 双指针


package com.jjzhou.algorithms.leetcode.editor.cn;

public class Q283MoveZeroes {

    public static void main(String[] args) {
       Solution solution = new Q283MoveZeroes().new Solution();
       int[] nums = new int[]{0, 1, 0, 3, 12};
       solution.moveZeroes(nums);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void moveZeroes(int[] nums) {
        if (null == nums || nums.length == 0) {
            return;
        }
        for (int i = 1, len = nums.length; i < len; i ++) {
            if (0 == nums[i - 1]) {
                for (int j = i; j < len; j ++) {
                    if (nums[j] != 0) {
                        nums[i -1] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
