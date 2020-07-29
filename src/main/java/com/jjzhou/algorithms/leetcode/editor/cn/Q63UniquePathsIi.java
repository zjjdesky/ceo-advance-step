//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
//
//
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。
//
// 说明：m 和 n 的值均不超过 100。
//
// 示例 1:
//
// 输入:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//输出: 2
//解释:
//3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
//
// Related Topics 数组 动态规划


package com.jjzhou.algorithms.leetcode.editor.cn;

import java.util.Arrays;

public class Q63UniquePathsIi {

    public static void main(String[] args) {
       Solution solution = new Q63UniquePathsIi().new Solution();
       int[][] obs = new int[1][2];
       obs[0][0] = 0;
       obs[0][1] = 1;
        System.out.println(solution.uniquePathsWithObstacles(obs));
    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (null == obstacleGrid || 0 == obstacleGrid.length) {
            return 0;
        }
        int rowLen = obstacleGrid.length;
        int colLen = obstacleGrid[0].length;
        int[][] memory = new int[rowLen][colLen];
        for (int i = 0; i < rowLen; i ++) {
            Arrays.fill(memory[i], 0);
        }
        return uniquePathsWithObstacles(0, 0, obstacleGrid, memory);
    }

    private int uniquePathsWithObstacles(int row, int col, int[][] obstacleGrid, int[][] memory) {
        if (1 == obstacleGrid[row][col]) {
            return 0;
        }
        if (row == obstacleGrid.length - 1 && col == obstacleGrid[0].length - 1 && obstacleGrid[row][col] == 0) {
            return 1;
        }
        if (0 == memory[row][col]) {
            if (row == obstacleGrid.length - 1 && col < obstacleGrid[0].length - 1) {
                memory[row][col] = uniquePathsWithObstacles(row, col + 1, obstacleGrid, memory);
                return memory[row][col];
            }
            if (row < obstacleGrid.length - 1 && col == obstacleGrid[0].length - 1) {
                memory[row][col] = uniquePathsWithObstacles(row + 1, col, obstacleGrid, memory);
                return memory[row][col];
            }
            memory[row][col] = uniquePathsWithObstacles(row + 1, col, obstacleGrid, memory) + uniquePathsWithObstacles(row, col + 1, obstacleGrid, memory);
            return memory[row][col];
        }
        return memory[row][col];
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
