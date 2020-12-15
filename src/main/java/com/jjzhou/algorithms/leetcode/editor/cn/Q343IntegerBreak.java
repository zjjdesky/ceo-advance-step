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

public class Q343IntegerBreak {

    public static void main(String[] args) {
       Solution solution = new Q343IntegerBreak().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 递归
     * integerBreak(n) 表示分隔n的最大乘积
     * eg. 分割n
     * (1). 1 * 分割(n - 1)
     * (2). 2 * 分割(n - 2)
     * ......
     * (n - 1). (n - 1) * 分割1
     * @param n
     * @return
     */
    public int integerBreak(int n) {
        if (n <= 1) {
            return n;
        }
        // memo[i] 表示分隔i的最大乘积
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return integerBreak(n, memo);
    }

    private int integerBreak(int n, int[] memo) {
        if (n == 1) {
            return 1;
        }
        int res = -1;
        if (-1 != memo[n]) {
            return memo[n];
        }
        for (int i = 1; i < n ;i ++) {
            res = max3(res, i * (n - i), i * integerBreak(n - i, memo));
        }
        memo[n] = res;
        return res;
    }

    private int max3(int x, int y, int z) {
        return Math.max(Math.max(x, y), z);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
