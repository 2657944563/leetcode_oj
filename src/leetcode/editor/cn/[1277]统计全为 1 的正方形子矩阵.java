// 开始时间：2025-08-20 18:27:12
// 题目标题：统计全为 1 的正方形子矩阵
// 题目标记：count-square-submatrices-with-all-ones
// 题目编号：1277
// 题目描述：

/**
 * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix =
 * [
 *   [0,1,1,1],
 *   [1,1,1,1],
 *   [0,1,1,1]
 * ]
 * 输出：15
 * 解释：
 * 边长为 1 的正方形有 10 个。
 * 边长为 2 的正方形有 4 个。
 * 边长为 3 的正方形有 1 个。
 * 正方形的总数 = 10 + 4 + 1 = 15.
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：matrix =
 * [
 * [1,0,1],
 * [1,1,0],
 * [1,1,0]
 * ]
 * 输出：7
 * 解释：
 * 边长为 1 的正方形有 6 个。
 * 边长为 2 的正方形有 1 个。
 * 正方形的总数 = 6 + 1 = 7.
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= arr.length <= 300
 * 1 <= arr[0].length <= 300
 * 0 <= arr[i][j] <= 1
 * <p>
 * <p>
 * Related Topics 数组 动态规划 矩阵 👍 373 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] f = new int[m + 1][n + 1];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] > 0) {
                    f[i + 1][j + 1] = Math.min(Math.min(f[i][j], f[i][j + 1]), f[i + 1][j]) + 1;
                    ans += f[i + 1][j + 1];
                }
            }
        }
        return ans;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

