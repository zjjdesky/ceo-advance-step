//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//
// 有效字符串需满足：
//
//
// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合。
//
//
// 注意空字符串可被认为是有效字符串。
//
// 示例 1:
//
// 输入: "()"
//输出: true
//
//
// 示例 2:
//
// 输入: "()[]{}"
//输出: true
//
//
// 示例 3:
//
// 输入: "(]"
//输出: false
//
//
// 示例 4:
//
// 输入: "([)]"
//输出: false
//
//
// 示例 5:
//
// 输入: "{[]}"
//输出: true
// Related Topics 栈 字符串
// 👍 1751 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Stack;

public class Q20ValidParentheses {

    public static void main(String[] args) {
       Solution solution = new Q20ValidParentheses().new Solution();
        System.out.println(solution.isValid("()"));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        if (Objects.isNull(s) || s.length() == 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> bracketsMap = new HashMap<>();
        bracketsMap.put('(', ')');
        bracketsMap.put('[', ']');
        bracketsMap.put('{', '}');
        for (int i = 0, len = s.length(); i < len; i ++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
            } else if (Objects.isNull(bracketsMap.get(stack.peek())) || bracketsMap.get(stack.peek()) != s.charAt(i)) {
                stack.push(s.charAt(i));
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
