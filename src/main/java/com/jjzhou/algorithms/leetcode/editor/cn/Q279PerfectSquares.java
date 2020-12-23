//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
//
// 示例 1:
//
// 输入: n = 12
//输出: 3
//解释: 12 = 4 + 4 + 4.
//
// 示例 2:
//
// 输入: n = 13
//输出: 2
//解释: 13 = 4 + 9.
// Related Topics 广度优先搜索 数学 动态规划
// 👍 710 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

public class Q279PerfectSquares {

    public static void main(String[] args) {
       Solution solution = new Q279PerfectSquares().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * f(n)
     * 定义：表示正整数n的最少的的完全平方数
     * f(n) = min(f(n), f(n - i * i) + 1)
     * @param n
     * @return
     */
    public int numSquares(int n) {
        assert n > 0;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i ++) {
            // 最差的情况就是每次+1
            dp[i] = i;
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
