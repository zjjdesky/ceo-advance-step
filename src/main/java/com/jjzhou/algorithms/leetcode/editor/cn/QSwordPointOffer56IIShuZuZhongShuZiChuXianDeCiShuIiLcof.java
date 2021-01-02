//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
//
//
//
// 示例 1：
//
// 输入：nums = [3,4,3,3]
//输出：4
//
//
// 示例 2：
//
// 输入：nums = [9,1,7,9,7,9,7]
//输出：1
//
//
//
// 限制：
//
//
// 1 <= nums.length <= 10000
// 1 <= nums[i] < 2^31
//
//
//
// 👍 112 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

public class QSwordPointOffer56IIShuZuZhongShuZiChuXianDeCiShuIiLcof {

    public static void main(String[] args) {
       Solution solution = new QSwordPointOffer56IIShuZuZhongShuZiChuXianDeCiShuIiLcof().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 如果一个数字出现三次，那么它的二进制表示的每一位也会出现三次
     * 如果把所有出现三次的数字的二进制表示的每一位都分别加起来，那么每一位的和都能被整除
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        assert nums != null && nums.length != 0;

        int[] bitSum = new int[32];
        for (int i = 0, len = nums.length; i < len; i ++) {
            int bitMask = 1;
            for (int j = 31; j >= 0; j --) {
                int bit = nums[i] & bitMask;
                if (bit != 0) {
                    bitSum[j] += 1;
                }
                bitMask = bitMask << 1;
            }
        }
        int res = 0;
        for (int j = 0; j < 32; j ++) {
            res = res << 1;
            res += bitSum[j] % 3; // 返回的结果只可能有0/1
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
