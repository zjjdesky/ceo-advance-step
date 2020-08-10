//给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
//
// 说明：解集不能包含重复的子集。
//
// 示例:
//
// 输入: nums = [1,2,3]
//输出:
//[
//  [3],
//  [1],
//  [2],
//  [1,2,3],
//  [1,3],
//  [2,3],
//  [1,2],
//  []
//]
// Related Topics 位运算 数组 回溯算法
// 👍 692 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Q78Subsets {

    public static void main(String[] args) {
       Solution solution = new Q78Subsets().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (Objects.isNull(nums) || 0 == nums.length) {
            return ans;
        }
        dfs(nums, new ArrayList<>(), ans, 0);
        return ans;
    }

    private void dfs(int[] nums, ArrayList<Integer> tmpList, List<List<Integer>> ans, int index) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(tmpList));
            return;
        }
        // 不选index
        dfs(nums, tmpList, ans, index + 1);
        tmpList.add(nums[index]);
        // 选择index
        dfs(nums, tmpList, ans, index + 1);
        tmpList.remove(tmpList.size() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
