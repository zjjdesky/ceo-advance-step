//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。
//
//
//
//
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。
//
//
//
//
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。
//
//
//
// 示例:
//
// 输入: [2,1,5,6,2,3]
//输出: 10
// Related Topics 栈 数组
// 👍 836 👎 0


package com.jjzhou.algorithms.leetcode.editor.cn;

public class Q84LargestRectangleInHistogram {

    public static void main(String[] args) {
       Solution solution = new Q84LargestRectangleInHistogram().new Solution();

    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int largestRectangleArea(int[] heights) {
        if (null == heights || 0 == heights.length) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0, len = heights.length; i < len; i ++) {
            for (int j = i; j < len; j ++) {
                int tmp = minHeight(heights, i, j) * (j - i + 1);
                if (maxArea < tmp) {
                    maxArea = tmp;
                }
            }
        }
        return maxArea;
    }

    private int minHeight(int[] heights, int start, int end) {
        if (start == end) {
            return heights[start];
        }
        int min = heights[start];
        for (int i = start + 1; i <= end; i ++) {
            if (heights[i] < min) {
                min = heights[i];
            }
        }
        return min;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
