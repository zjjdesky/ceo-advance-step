package com.jjzhou.algorithms.leetcode.helper.dp.knapsack;

/**
 * @author jjzhou
 * @date 2020/12/14 8:56 下午
 * @description
 */
public class Knapsack01 {

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
        return maxValue(w, v, c, n - 1);
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
    private int maxValue(int[] w, int[] v, int c, int index) {
        if (c <= 0 || index < 0) {
            return 0;
        }
        int res = maxValue(w, v, c, index - 1);
        if (w[index] <= c) {
            res = Math.max(res, maxValue(w, v, c - w[index], index - 1));
        }
        return res;
    }
}
