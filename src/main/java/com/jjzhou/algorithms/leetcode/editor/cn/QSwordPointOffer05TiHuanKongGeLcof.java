//请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
//
//
//
// 示例 1：
//
// 输入：s = "We are happy."
//输出："We%20are%20happy."
//
//
//
// 限制：
//
// 0 <= s 的长度 <= 10000
// 👍 56 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

public class QSwordPointOffer05TiHuanKongGeLcof {

    public static void main(String[] args) {
       Solution solution = new QSwordPointOffer05TiHuanKongGeLcof().new Solution();
        solution.replaceSpace("we are happy");
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String replaceSpace(String s) {
        if (null == s) {
            return null;
        }
        char[] ch = s.toCharArray();
        int spaceCount = 0;
        for (int i = 0, len = ch.length; i < len; i ++) {
            if (ch[i] == ' ') {
                spaceCount ++;
            }
        }
        if (0 == spaceCount) {
            return s;
        }
        int newChLen = ch.length + 2 * spaceCount;
        char[] newCh = new char[newChLen];
        int p1 = ch.length - 1, p2 = newChLen - 1;
        while (spaceCount-- > 0) {
            while (ch[p1] != ' ') {
                newCh[p2--] = ch[p1--];
            }
            fillSpace(newCh, p2);
            p1--;
            p2 -= 3;
        }
        while (p1 >= 0) {
            newCh[p1] = ch[p1];
            p1 --;
        }
        return new String(newCh, 0, newChLen);
    }

    private void fillSpace(char[] ch, int index) {
        ch[index] = '0';
        ch[--index] = '2';
        ch[--index] = '%';
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
