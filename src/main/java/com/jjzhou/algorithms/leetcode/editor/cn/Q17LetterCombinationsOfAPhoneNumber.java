//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
// 示例:
//
// 输入："23"
//输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//
//
// 说明:
//尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
// Related Topics 字符串 回溯算法
// 👍 821 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Q17LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
       Solution solution = new Q17LetterCombinationsOfAPhoneNumber().new Solution();
        solution.letterCombinations("23");
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (Objects.isNull(digits) || 0 == digits.length()) {
            return ans;
        }
        Map<String, List<String>> phoneNumberLetterMap = new HashMap<>();
        phoneNumberLetterMap.put("2", Arrays.asList("a", "b", "c"));
        phoneNumberLetterMap.put("3", Arrays.asList("d", "e", "f"));
        phoneNumberLetterMap.put("4", Arrays.asList("g", "h", "i"));
        phoneNumberLetterMap.put("5", Arrays.asList("j", "k", "l"));
        phoneNumberLetterMap.put("6", Arrays.asList("m", "n", "o"));
        phoneNumberLetterMap.put("7", Arrays.asList("p", "q", "r", "s"));
        phoneNumberLetterMap.put("8", Arrays.asList("t", "u", "v"));
        phoneNumberLetterMap.put("9", Arrays.asList("w", "x", "y", "z"));
        List<String> digitArrays = new ArrayList<>();
        for (int i = 0; i < digits.length(); i ++) {
            digitArrays.add(String.valueOf(digits.charAt(i)));
        }
        StringBuffer sbTmp = new StringBuffer();
        letterCombinations(digitArrays, phoneNumberLetterMap, 0, sbTmp, ans);
        return ans;
    }

    private void letterCombinations(List<String> digitArrays, Map<String, List<String>> phoneNumberLetterMap, int index, StringBuffer sbTmp, List<String> ans) {
        if (index == digitArrays.size()) {
            ans.add(sbTmp.toString());
            return;
        }
        List<String> currentLetterList = phoneNumberLetterMap.get(digitArrays.get(index));
        for (int i = 0; i < currentLetterList.size(); i ++) {
            sbTmp.append(currentLetterList.get(i));
            letterCombinations(digitArrays, phoneNumberLetterMap, index + 1, sbTmp, ans);
            sbTmp.deleteCharAt(sbTmp.length() - 1);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)


}
