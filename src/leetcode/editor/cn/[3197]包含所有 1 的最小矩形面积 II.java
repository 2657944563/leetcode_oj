// 开始时间：2025-08-23 19:41:09
// 题目标题：包含所有 1 的最小矩形面积 II
// 题目标记：find-the-minimum-area-to-cover-all-ones-ii
// 题目编号：3197
// 题目描述：

/**
 * 给你一个二维 二进制 数组 grid。你需要找到 3 个 不重叠、面积 非零 、边在水平方向和竖直方向上的矩形，并且满足 grid 中所有的 1 都在这些矩形的
 * 内部。
 * <p>
 * 返回这些矩形面积之和的 最小 可能值。
 * <p>
 * 注意，这些矩形可以相接。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入： grid = [[1,0,1],[1,1,1]]
 * <p>
 * <p>
 * 输出： 5
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * <p>
 * 位于 (0, 0) 和 (1, 0) 的 1 被一个面积为 2 的矩形覆盖。
 * 位于 (0, 2) 和 (1, 2) 的 1 被一个面积为 2 的矩形覆盖。
 * 位于 (1, 1) 的 1 被一个面积为 1 的矩形覆盖。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入： grid = [[1,0,1,0],[0,1,0,1]]
 * <p>
 * <p>
 * 输出： 5
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * <p>
 * 位于 (0, 0) 和 (0, 2) 的 1 被一个面积为 3 的矩形覆盖。
 * 位于 (1, 1) 的 1 被一个面积为 1 的矩形覆盖。
 * 位于 (1, 3) 的 1 被一个面积为 1 的矩形覆盖。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= grid.length, grid[i].length <= 30
 * grid[i][j] 是 0 或 1。
 * 输入保证 grid 中至少有三个 1 。
 * <p>
 * <p>
 * Related Topics 数组 枚举 矩阵 👍 29 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    private int minimumSum2(int[][] grid, int u, int d, int l, int r) {
        int min_i = grid.length, max_i = 0;
        int min_j = grid[0].length, max_j = 0;
        for (int i = u; i <= d; i++) {
            for (int j = l; j <= r; j++) {
                if (grid[i][j] == 1) {
                    min_i = Math.min(min_i, i);
                    min_j = Math.min(min_j, j);
                    max_i = Math.max(max_i, i);
                    max_j = Math.max(max_j, j);
                }
            }
        }
        return min_i <= max_i ? (max_i - min_i + 1) * (max_j - min_j + 1) : Integer.MAX_VALUE / 3;
    }

    private int[][] rotate(int[][] vec) {
        int n = vec.length, m = vec[0].length;
        int[][] ret = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ret[m - j - 1][i] = vec[i][j];
            }
        }
        return ret;
    }

    private int solve(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int res = n * m;
        for (int i = 0; i + 1 < n; i++) {
            for (int j = 0; j + 1 < m; j++) {
                res = Math.min(res, minimumSum2(grid, 0, i, 0, m - 1)
                        + minimumSum2(grid, i + 1, n - 1, 0, j)
                        + minimumSum2(grid, i + 1, n - 1, j + 1, m - 1));
                res = Math.min(res, minimumSum2(grid, 0, i, 0, j)
                        + minimumSum2(grid, 0, i, j + 1, m - 1)
                        + minimumSum2(grid, i + 1, n - 1, 0, m - 1));
            }
        }
        for (int i = 0; i + 2 < n; i++) {
            for (int j = i + 1; j + 1 < n; j++) {
                res = Math.min(res, minimumSum2(grid, 0, i, 0, m - 1)
                        + minimumSum2(grid, i + 1, j, 0, m - 1)
                        + minimumSum2(grid, j + 1, n - 1, 0, m - 1));
            }
        }
        return res;
    }

    public int minimumSum(int[][] grid) {
        int[][] rgrid = rotate(grid);
        return Math.min(solve(grid), solve(rgrid));
    }
}

//leetcode submit region end(Prohibit modification and deletion)

