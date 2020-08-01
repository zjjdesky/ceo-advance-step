//给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
//
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
//例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
//
//
// 若这两个字符串没有公共子序列，则返回 0。
//
//
//
// 示例 1:
//
// 输入：text1 = "abcde", text2 = "ace"
//输出：3
//解释：最长公共子序列是 "ace"，它的长度为 3。
//
//
// 示例 2:
//
// 输入：text1 = "abc", text2 = "abc"
//输出：3
//解释：最长公共子序列是 "abc"，它的长度为 3。
//
//
// 示例 3:
//
// 输入：text1 = "abc", text2 = "def"
//输出：0
//解释：两个字符串没有公共子序列，返回 0。
//
//
//
//
// 提示:
//
//
// 1 <= text1.length <= 1000
// 1 <= text2.length <= 1000
// 输入的字符串只含有小写英文字符。
//
// Related Topics 动态规划
// 👍 190 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

import java.util.Arrays;
import java.util.Objects;

public class Q1143LongestCommonSubsequence {

    public static void main(String[] args) {
       Solution solution = new Q1143LongestCommonSubsequence().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 思路：升维
     * text1[i] == text[j] -> f(i, j) = f(i - 1, j - 1) + 1
     * text1[i] != text[j] -> f(i, j) = max(f(i - 1, j), f(i, j - 1))
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        if (Objects.isNull(text1) || Objects.isNull(text2) ||
            0 == text1.length() || 0 == text2.length()) {
            return 0;
        }
        if (text1.equals(text2) || text1.contains(text2) || text2.contains(text1)) {
            return Math.min(text1.length(), text2.length());
        }
        int[][] f = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i ++) {
            f[i][0] = text1.charAt(i) == text2.charAt(0) ? 1 : f[i - 1][0];
        }
        for (int j = 0; j < text2.length(); j ++) {
            f[0][j] = text1.charAt(0) == text2.charAt(j) ? 1 : f[0][j - 1];
        }

        for (int i = 1; i < text1.length(); i ++) {
            for (int j = 1; j < text2.length(); j ++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                }
            }
        }
        return f[text1.length() - 1][text2.length() - 1];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
