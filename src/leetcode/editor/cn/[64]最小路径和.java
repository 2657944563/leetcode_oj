// 开始时间：2023-09-26 18:41:29
// 题目标题：最小路径和
// 题目标记：minimum-path-sum
// 题目编号：64
// 题目描述：

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * <p>
 * 说明：每次只能向下或者向右移动一步。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
 * 输出：7
 * 解释：因为路径 1→3→1→1→1 的总和最小。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6]]
 * 输出：12
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 200
 * 0 <= grid[i][j] <= 200
 * <p>
 * <p>
 * Related Topics 数组 动态规划 矩阵 👍 1579 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPathSum(int[][] grid) {
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                int min = (i == grid.length - 1 && j == grid[0].length - 1) ? 0 : Integer.MAX_VALUE;
                if (i + 1 < grid.length) {
                    min = grid[i + 1][j];
                }
                if (j + 1 < grid[i].length) {
                    min = Math.min(min, grid[i][j + 1]);
                }
                grid[i][j] += min;
            }
        }
        return grid[0][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

