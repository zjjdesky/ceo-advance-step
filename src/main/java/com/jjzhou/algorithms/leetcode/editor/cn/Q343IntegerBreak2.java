//给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
//
// 示例 1:
//
// 输入: 2
//输出: 1
//解释: 2 = 1 + 1, 1 × 1 = 1。
//
// 示例 2:
//
// 输入: 10
//输出: 36
//解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
//
// 说明: 你可以假设 n 不小于 2 且不大于 58。
// Related Topics 数学 动态规划
// 👍 414 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

import java.util.Arrays;

public class Q343IntegerBreak2 {

    public static void main(String[] args) {
       Solution solution = new Q343IntegerBreak2().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 动态规划
     * dp[n] 表示分隔n的最大值
     * dp[n] = max(n, i * dp[n - i])
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        int max = -1;
        for (int i = 2; i <= n; i ++) {
            for (int j = 1; j < i; j ++) {
                max = max3(max, j * dp[i - j], j * (i - j));
            }
            dp[i] = max;
        }
        return dp[n];
    }

    private int max3(int x, int y, int z) {
        return Math.max(Math.max(x, y), z);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
