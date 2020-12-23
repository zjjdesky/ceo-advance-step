//给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
//
//
//
// 示例：
//
// s = "leetcode"
//返回 0
//
//s = "loveleetcode"
//返回 2
//
//
//
//
// 提示：你可以假定该字符串只包含小写字母。
// Related Topics 哈希表 字符串
// 👍 301 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

import java.util.Arrays;

public class Q387FirstUniqueCharacterInAString {

    public static void main(String[] args) {
       Solution solution = new Q387FirstUniqueCharacterInAString().new Solution();
        System.out.println(solution.firstUniqChar("aadadaad"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {
        if (null == s || 0 == s.length()) {
            return -1;
        }
        int[] h = new int[26];
        Arrays.fill(h, Integer.MAX_VALUE);
        char[] ch = s.toCharArray();
        int index;
        for (int i = 0, len = ch.length; i < len; i ++) {
            index = ch[i] - 'a';
            assert index >= 0;
            if (h[index] == Integer.MAX_VALUE) {
                h[index] = i;
            } else {
                h[index] = -1;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0, len = h.length; i < len; i ++) {
            if (h[i] == -1) {
                continue;
            }
            if (min > h[i]) {
                min = h[i];
            }
        }
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
