//给定一个可包含重复数字的序列，返回所有不重复的全排列。
//
// 示例:
//
// 输入: [1,1,2]
//输出:
//[
//  [1,1,2],
//  [1,2,1],
//  [2,1,1]
//]
// Related Topics 回溯算法
// 👍 370 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

import java.util.*;

public class Q47PermutationsIi {

    public static void main(String[] args) {
       Solution solution = new Q47PermutationsIi().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (Objects.isNull(nums) || 0 == nums.length) {
            return ans;
        }
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        dfs(nums, used, new ArrayDeque<>(), ans, 0);
        return ans;
    }

    private void dfs(int[] nums, boolean[] used, ArrayDeque<Integer> tmpAnsDeque, List<List<Integer>> ans, int depth) {
        if (depth == nums.length) {
            ans.add(new ArrayList<>(tmpAnsDeque));
            return;
        }
        for (int i = 0; i < nums.length; i ++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            used[i] = true;
            tmpAnsDeque.addLast(nums[i]);
            dfs(nums, used, tmpAnsDeque, ans, depth + 1);
            tmpAnsDeque.removeLast();
            used[i] = false;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
