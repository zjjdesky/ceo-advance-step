//给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
//
// 示例 1:
//
// 输入: 123
//输出: 321
//
//
// 示例 2:
//
// 输入: -123
//输出: -321
//
//
// 示例 3:
//
// 输入: 120
//输出: 21
//
//
// 注意:
//
// 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
// Related Topics 数学
// 👍 2136 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

public class Q7ReverseInteger {

    public static void main(String[] args) {
       Solution solution = new Q7ReverseInteger().new Solution();
       solution.reverse(123);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        int flag = 1;
        if (x < 0) {
            flag = -1;
            x = -x;
        }
        char[] ch = String.valueOf(x).toCharArray();
        int start = 0, end = ch.length - 1;
        char tmp;
        while (start < end) {
            tmp = ch[start];
            ch[start] = ch[end];
            ch[end] = tmp;
            start ++;
            end --;
        }
        long result = 0;
        for (int i = 0;i < ch.length; i ++) {
            result += (ch[i] - '0') * 10;
        }
        if (result > Integer.MAX_VALUE) {
            return 0;
        }
        return flag * Integer.parseInt(String.valueOf(result));
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
