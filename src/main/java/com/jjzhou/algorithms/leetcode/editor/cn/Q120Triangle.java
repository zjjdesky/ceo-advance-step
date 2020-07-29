//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
//
// 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
//
//
//
// 例如，给定三角形：
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
//
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
//
//
//
// 说明：
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
// Related Topics 数组 动态规划


package com.jjzhou.algorithms.leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Q120Triangle {

    public static void main(String[] args) {
       Solution solution = new Q120Triangle().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    /**
     * 思路：状态转移方程为：f(i, j) = min(f(i + 1, j), f(i + 1, j + 1))
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (Objects.isNull(triangle) || triangle.isEmpty()) {
            return 0;
        }
        for (int i = triangle.size() - 2; i >= 0; --i) {
            for (int j = 0, len = triangle.get(i).size(); j < len; ++j) {
                int f = Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)) + triangle.get(i).get(j);
                triangle.get(i).set(j, f);
            }
        }
        return triangle.get(0).get(0);
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
