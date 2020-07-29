//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。
//
//
//
// 示例 1:
//
// 输入: coins = [1, 2, 5], amount = 11
//输出: 3
//解释: 11 = 5 + 5 + 1
//
// 示例 2:
//
// 输入: coins = [2], amount = 3
//输出: -1
//
//
//
// 说明:
//你可以认为每种硬币的数量是无限的。
// Related Topics 动态规划
// 👍 722 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Objects;

public class Q322CoinChange {

    public static void main(String[] args) {
       Solution solution = new Q322CoinChange().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 思路：类比于爬楼梯
     * 定义：表示价值为amount所需要的硬币数
     * f(amount) = min{f(amount - ...coins)} + 1
     * f(amount) = min(f(amount - coins[j]) + 1, f(amount))
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        if (Objects.isNull(coins) || coins.length == 0 || amount < 0) {
            return -1;
        }
        int[] f = new int[amount + 1];
        Arrays.fill(f, amount + 1);
        f[0] = 0;
        for (int i = 1; i <= amount;i ++) {
            for (int j = 0; j < coins.length; j ++) {
                if (i >= coins[j]) {
                    f[i] = Math.min(f[i - coins[j]] + 1, f[i]);
                }
            }
        }
        return f[amount] > amount ? -1 : f[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
