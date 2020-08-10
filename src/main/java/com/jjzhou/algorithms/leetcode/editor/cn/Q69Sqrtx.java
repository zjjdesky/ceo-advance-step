//实现 int sqrt(int x) 函数。
//
// 计算并返回 x 的平方根，其中 x 是非负整数。
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
//
// 示例 1:
//
// 输入: 4
//输出: 2
//
//
// 示例 2:
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842...,
//     由于返回类型是整数，小数部分将被舍去。
//
// Related Topics 数学 二分查找
// 👍 466 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

public class Q69Sqrtx {

    public static void main(String[] args) {
       Solution solution = new Q69Sqrtx().new Solution();
        System.out.println(solution.mySqrt(2147395599));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int mySqrt(int x) {
        if (x <= 0) {
            return 0;
        }
        int left = 0, right = x, mid = 0;
        long tmp = 0L;
        int ans = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            tmp = (long) mid * mid;
            if (tmp <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid -1;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
