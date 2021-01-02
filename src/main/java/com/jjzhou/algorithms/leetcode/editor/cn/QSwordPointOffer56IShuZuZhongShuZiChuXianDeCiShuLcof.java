//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
//
//
//
// 示例 1：
//
// 输入：nums = [4,1,4,6]
//输出：[1,6] 或 [6,1]
//
//
// 示例 2：
//
// 输入：nums = [1,2,10,4,1,4,3,3]
//输出：[2,10] 或 [10,2]
//
//
//
// 限制：
//
//
// 2 <= nums.length <= 10000
//
//
//
// 👍 277 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

public class QSwordPointOffer56IShuZuZhongShuZiChuXianDeCiShuLcof {

    public static void main(String[] args) {
       Solution solution = new QSwordPointOffer56IShuZuZhongShuZiChuXianDeCiShuLcof().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 将nums拆分成两个数组，使得每个数组包含一个只出现一次的数字，其他数字都出现两次
     * 1. 从头到尾异或数组中的每个数字，最终的结果就是两个只出现一次的数字异或的结果
     * 2. 在异或结果中找到第一个为1的位的位置，记录下来。
     *    因为两个位不相等才会等于1，所以按照这个区分，肯定会将两个不是成对出现的数字分开。
     * 3. 分成两个数组，直接进行异或，得到结果
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return null;
        }
        if (nums.length == 2) {
            return nums;
        }
        assert nums.length > 2;
        int xorRes = 0;
        for (int i = 0, len = nums.length; i < len; i ++) {
            xorRes ^= nums[i];
        }
        int xorResIndex = indexOfFirstBitsIs1(xorRes);
        int res0 = 0, res1 = 0;
        for (int i = 0, len = nums.length; i < len; i ++) {
            if (isBits1(nums[i], xorResIndex)) {
                res1 ^= nums[i];
            } else {
                res0 ^= nums[i];
            }
        }
        return new int[] {res0, res1};
    }

    private int indexOfFirstBitsIs1(int num) {
        int index = 0;
        while ((num & 1) == 0) {
            num = num >> 1;
            ++index;
        }
        return index;
    }

    private boolean isBits1(int num, int index) {
        num = num >> index;
        return (num & 1) == 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
