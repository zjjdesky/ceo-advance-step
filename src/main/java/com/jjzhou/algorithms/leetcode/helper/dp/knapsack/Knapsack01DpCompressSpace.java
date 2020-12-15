package com.jjzhou.algorithms.leetcode.helper.dp.knapsack;

/**
 * @author jjzhou
 * @date 2020/12/14 9:31 下午
 * @description
 */
public class Knapsack01DpCompressSpace {

    /**
     * f(n, c)表示将n个物品放进容量为c的背包，使得价值最大
     * f(i, c) = max(f(i - 1, c), f(i - 1, c - w(i)) + v(i))
     * @param w
     * @param v
     * @param c
     * @return
     */
    public int knapsack01(int[] w, int[] v, int c) {
        if (null == w || null == v || c <= 0) {
            return 0;
        }
        assert w.length == v.length;
        int n = w.length;
        int[][] dp = new int[2][c + 1];
        for (int j = 0; j <= c; j ++) {
            dp[0][j] = j > w[0] ? v[0] : 0;
        }
        for (int i = 1; i < n; i ++) {
            for (int j = 1; j <=c; j ++) {
                dp[i % 2][j] = dp[i - 1][j];
                if (j > w[i]) {
                    dp[i % 2][j] = Math.max(dp[(i - 1) % 2][j], dp[(i - 1) % 2][j - w[i]] + v[i]);
                }
            }
        }
        return dp[(n - 1) % 2][c];
    }
}
