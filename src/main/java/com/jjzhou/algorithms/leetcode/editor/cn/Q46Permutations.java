//给定一个 没有重复 数字的序列，返回其所有可能的全排列。
//
// 示例:
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//]
// Related Topics 回溯算法


package com.jjzhou.algorithms.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Q46Permutations {

    public static void main(String[] args) {
       Solution solution = new Q46Permutations().new Solution();
       int[] nums = new int[]{1, 1, 3};
        List<List<Integer>> permute = solution.permute(nums);
        System.out.println(permute);
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<List<Integer>> permute(int[] nums) {
        if (null == nums || nums.length == 0) {
            return null;
        }
        List<List<Integer>> permuteResultList = new ArrayList<>();
        List<Integer> childResList = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        for (int i = 0, len = nums.length; i < len; i ++) {
            numList.add(nums[i]);
        }
        permute(numList, childResList, permuteResultList);
        return permuteResultList;
    }

    private void permute(List<Integer> numList, List<Integer> childResList, List<List<Integer>> permuteResultList) {
        if (0 == numList.size()) {
            List<Integer> childRes = new ArrayList<>(childResList);
            permuteResultList.add(childRes);
            return;
        }
        for (int i = 0, len = numList.size(); i < len; i ++) {
            Integer current = numList.get(i);
            childResList.add(current);
            List<Integer> newNumList = new ArrayList<>();
            for (int j = 0; j < i; j ++) {
                newNumList.add(numList.get(j));
            }
            for (int j = i + 1; j < len; j ++) {
                newNumList.add(numList.get(j));
            }
            permute(newNumList, childResList, permuteResultList);
            childResList.remove(current);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)


}
