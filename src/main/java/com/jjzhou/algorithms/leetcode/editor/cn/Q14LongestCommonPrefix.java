//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。
//
// 示例 1:
//
// 输入: ["flower","flow","flight"]
//输出: "fl"
//
//
// 示例 2:
//
// 输入: ["dog","racecar","car"]
//输出: ""
//解释: 输入不存在公共前缀。
//
//
// 说明:
//
// 所有输入只包含小写字母 a-z 。
// Related Topics 字符串
// 👍 1400 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

public class Q14LongestCommonPrefix {

    public static void main(String[] args) {
       Solution solution = new Q14LongestCommonPrefix().new Solution();
       String[] str = new String[]{"flower","flow","flight"};
       solution.longestCommonPrefix(str);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (null == strs || 0 == strs.length) {
            return "";
        }
        if (1 == strs.length) {
            return strs[0];
        }
        char[] ch0 = strs[0].toCharArray();
        int i;
        outLoop:
        for (i = 0; i < ch0.length; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || ch0[i] != strs[j].charAt(i)) {
                    break outLoop;
                }
            }
        }
        return new String(ch0, 0, i);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
