//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
//
// 注意：给定 n 是一个正整数。
//
// 示例 1：
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶
//
// 示例 2：
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
//
// Related Topics 动态规划


package com.jjzhou.algorithms.leetcode.editor.cn;

public class Q70ClimbingStairsS2 {

    public static void main(String[] args) {
       Solution solution = new Q70ClimbingStairsS2().new Solution();
        System.out.println(solution.climbStairs(2));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        if (1 == n || 2 == n) {
            return n;
        }
        int before1 = 2, before2 = 1, res = 0;
        for (int i = 3; i < n + 1; i ++) {
            res = before1 + before2;
            before2 = before1;
            before1 = res;
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
