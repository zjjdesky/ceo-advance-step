//找出数组中重复的数字。
//
//
//在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请
//找出数组中任意一个重复的数字。
//
// 示例 1：
//
// 输入：
//[2, 3, 1, 0, 2, 5, 3]
//输出：2 或 3
//
//
//
//
// 限制：
//
// 2 <= n <= 100000
// Related Topics 数组 哈希表
// 👍 240 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

public class QSwordPointOffer03ShuZuZhongZhongFuDeShuZiLcof {

    public static void main(String[] args) {
       Solution solution = new QSwordPointOffer03ShuZuZhongZhongFuDeShuZiLcof().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findRepeatNumber(int[] nums) {
        assert null != nums && nums.length > 1;
        int i = 0;
        while (i < nums.length) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                swap(nums, i, nums[i]);
            }
            i ++;
        }
        return 0;
    }

    private void swap(int[] nums, int index1, int index2) {
        int tmp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
