// 开始时间：2023-09-26 12:00:56
// 题目标题：不同路径
// 题目标记：unique-paths
// 题目编号：62
// 题目描述：

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：m = 3, n = 7
 * 输出：28
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：m = 7, n = 3
 * 输出：28
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * <p>
 * 输入：m = 3, n = 3
 * 输出：6
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 10⁹
 * <p>
 * <p>
 * Related Topics 数学 动态规划 组合数学 👍 1888 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            result[i][n - 1] = 1;
        }
        for (int i = 0; i < n; i++) {
            result[m - 1][i] = 1;
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int sum = 0;
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

