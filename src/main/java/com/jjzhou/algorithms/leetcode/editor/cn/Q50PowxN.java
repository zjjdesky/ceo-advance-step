//实现 pow(x, n) ，即计算 x 的 n 次幂函数。
//
// 示例 1:
//
// 输入: 2.00000, 10
//输出: 1024.00000
//
//
// 示例 2:
//
// 输入: 2.10000, 3
//输出: 9.26100
//
//
// 示例 3:
//
// 输入: 2.00000, -2
//输出: 0.25000
//解释: 2-2 = 1/22 = 1/4 = 0.25
//
// 说明:
//
//
// -100.0 < x < 100.0
// n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
//
// Related Topics 数学 二分查找
// 👍 463 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

public class Q50PowxN {

    public static void main(String[] args) {
       Solution solution = new Q50PowxN().new Solution();
        double res = solution.myPow(2, -2);
        System.out.println(res);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 快速幂
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        double ans = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                ans *= x;
            }
            x *= x;
        }
        return n < 0 ? 1 / ans : ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
