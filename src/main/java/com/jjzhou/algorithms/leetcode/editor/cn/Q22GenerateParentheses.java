//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//
//
// 示例：
//
// 输入：n = 3
//输出：[
//       "((()))",
//       "(()())",
//       "(())()",
//       "()(())",
//       "()()()"
//     ]
//
// Related Topics 字符串 回溯算法
// 👍 1283 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q22GenerateParentheses {

    public static void main(String[] args) {
       Solution solution = new Q22GenerateParentheses().new Solution();
        List<String> strings = solution.generateParenthesis(3);
        System.out.println(strings);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ansList = new ArrayList<>();
        if (n <= 0) {
            return ansList;
        }
        StringBuilder sb = new StringBuilder();
        generate(0, n,2 * n, ansList, sb);
        return ansList;
    }

    private void generate(int currentLevel, int totalCount, int maxLevel, List<String> ansList, StringBuilder sb) {
        if (currentLevel > maxLevel) {
            ansList.add(sb.toString());
            return;
        }
        int leftBrackets = countMatchBrackets(sb, '(');
        int rightBrackets = countMatchBrackets(sb, ')');
        int sbLength = sb.length();
        if (leftBrackets < totalCount) {
            generate(currentLevel + 1, totalCount, maxLevel, ansList, sb.append('('));
            sb.deleteCharAt(sbLength);
        }
        if (leftBrackets > rightBrackets) {
            generate(currentLevel + 1, totalCount, maxLevel, ansList, sb.append(')'));
            sb.deleteCharAt(sbLength);
        }
    }

    private int countMatchBrackets(StringBuilder sb, char brackets) {
        if (sb.length() == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < sb.length(); i ++) {
            if (brackets == sb.charAt(i)) {
                count ++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
