package com.jjzhou.algorithms.leetcode.helper.dp.knapsack;

import java.util.Arrays;

/**
 * @author jjzhou
 * @date 2020/12/14 8:56 下午
 * @description
 */
public class Knapsack01Memo {

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
        int[][] memo = new int[n][c + 1];
        for (int i = 0; i < n; i ++) {
            Arrays.fill(memo[i], -1);
        }
        return maxValue(w, v, c, n - 1, memo);
    }

    /**
     * f(n, c)表示将n个物品放进容量为c的背包，使得价值最大
     * f(i, c) = max(f(i - 1, c), f(i - 1, c - w(i)) + v(i))
     * 表示[0, index]的物品，填充容积为c的背包的最大价值
     * @param w
     * @param v
     * @param c
     * @param index
     * @return
     */
    private int maxValue(int[] w, int[] v, int c, int index, int[][] memo) {
        if (c <= 0 || index < 0) {
            return 0;
        }
        if (memo[index][c] != -1) {
            return memo[index][c];
        }
        int res = maxValue(w, v, c, index - 1, memo);
        if (w[index] <= c) {
            res = Math.max(res, maxValue(w, v, c - w[index], index - 1, memo) + v[index]);
        }
        memo[index][c] = res;
        return res;
    }
}
