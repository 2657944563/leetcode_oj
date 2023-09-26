// 开始时间：2023-09-26 12:09:53
// 题目标题：不同路径 II
// 题目标记：unique-paths-ii
// 题目编号：63
// 题目描述：

/**
 * 一个机器人位于一个
 * m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：obstacleGrid = [[0,1],[0,0]]
 * 输出：1
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] 为 0 或 1
 * <p>
 * <p>
 * Related Topics 数组 动态规划 矩阵 👍 1153 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] result = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            if (obstacleGrid[i][n - 1] == 1) {
                break;
            }
            result[i][n - 1] = 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            if (obstacleGrid[m - 1][i] == 1) {
                break;
            }
            result[m - 1][i] = 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int sum = 0;
                if (obstacleGrid[i][j] == 1) {
                    result[i][j] = sum;
                    continue;
                }
                if (i + 1 < m) {
                    sum += result[i + 1][j];
                }
                if (j + 1 < n) {
                    sum += result[i][j + 1];
                }
                result[i][j] = sum;
            }
        }
        return result[0][0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

