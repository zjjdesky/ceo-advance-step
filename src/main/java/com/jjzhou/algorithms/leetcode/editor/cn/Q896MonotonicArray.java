//如果数组是单调递增或单调递减的，那么它是单调的。
//
// 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是
//单调递减的。
//
// 当给定的数组 A 是单调数组时返回 true，否则返回 false。
//
//
//
//
//
//
// 示例 1：
//
// 输入：[1,2,2,3]
//输出：true
//
//
// 示例 2：
//
// 输入：[6,5,4,4]
//输出：true
//
//
// 示例 3：
//
// 输入：[1,3,2]
//输出：false
//
//
// 示例 4：
//
// 输入：[1,2,4,5]
//输出：true
//
//
// 示例 5：
//
// 输入：[1,1,1]
//输出：true
//
//
//
//
// 提示：
//
//
// 1 <= A.length <= 50000
// -100000 <= A[i] <= 100000
//
// Related Topics 数组
// 👍 74 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

public class Q896MonotonicArray {

    public static void main(String[] args) {
       Solution solution = new Q896MonotonicArray().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMonotonic(int[] A) {
        if (null == A || 0 == A.length) {
            return false;
        }
        if (1 == A.length) {
            return true;
        }
        // -1 递减 0 不变 1 递增
        int maxDiff = A[A.length - 1] - A[0];
        int state = maxDiff == 0 ? 0 : ((maxDiff > 0) ? 1 : -1);
        int diff = 0;
        // 用switch case比较快
        for (int i = 1, len = A.length; i < len; i ++) {
            diff = A[i] - A[i - 1];
            switch (state) {
                case -1:
                    if (diff > 0) {
                        return false;
                    }
                    break;
                case 0:
                    if (diff != 0) {
                        return false;
                    }
                    break;
                case 1:
                    if (diff < 0) {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
