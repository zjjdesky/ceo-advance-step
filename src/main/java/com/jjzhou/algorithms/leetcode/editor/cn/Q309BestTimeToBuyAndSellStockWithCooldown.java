//给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。 
//
// 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）: 
//
// 
// 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
// 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。 
// 
//
// 示例: 
//
// 输入: [1,2,3,0,2]
//输出: 3 
//解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出] 
// Related Topics 动态规划 
// 👍 648 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class Q309BestTimeToBuyAndSellStockWithCooldown {

    public static void main(String[] args) {
       Solution solution = new Q309BestTimeToBuyAndSellStockWithCooldown().new Solution();
       
    }
  
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 0: 未持有 1: 持有
     * f(i, 0) = max(f(i - 1, 0), f(i - 1, 1) + p(i))
     * f(i, 1) = max(f(i - 1, 1), f(i - 2, 0) - p(i))
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        if (null == prices || 0 == prices.length) {
            return 0;
        }
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1, len = prices.length; i < len; i ++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], (i - 2) < 0 ? -prices[i] : dp[i - 2][0] - prices[i]);
        }
        return dp[prices.length - 1][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  
}