//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
// 说明：本题中，我们将空字符串定义为有效的回文串。
//
// 示例 1:
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
//
//
// 示例 2:
//
// 输入: "race a car"
//输出: false
//
// Related Topics 双指针 字符串
// 👍 308 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

public class Q125ValidPalindrome {

    public static void main(String[] args) {
       Solution solution = new Q125ValidPalindrome().new Solution();
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        if (null == s) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }
        char[] ch = s.toCharArray();
        int i = 0, j = ch.length - 1;
        while (i < j) {
            while (!isLetterOrNumber(ch[i])) {
                i ++;
            }
            while (!isLetterOrNumber(ch[j])) {
                j --;
            }
            if (!isEquals(ch[i], ch[j])) {
                return false;
            }
            i ++;
            j --;
        }
        return true;
    }

    private boolean isEquals(char ch1, char ch2) {
        if (ch1 == ch2) {
            return true;
        }
        ch1 = Character.toUpperCase(ch1);
        ch2 = Character.toUpperCase(ch2);
        return ch1 == ch2;
    }

    private boolean isLetterOrNumber(char ch) {
        if (ch >= 'a' && ch <= 'z') {
            return true;
        }
        if (ch >= 'A' && ch <= 'Z') {
            return true;
        }
        if (ch >= '0' && ch <= '9') {
            return true;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
