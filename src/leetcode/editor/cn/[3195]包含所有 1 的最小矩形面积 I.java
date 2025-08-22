// 开始时间：2025-08-22 20:39:40
// 题目标题：包含所有 1 的最小矩形面积 I
// 题目标记：find-the-minimum-area-to-cover-all-ones-i
// 题目编号：3195
// 题目描述：

/**
 * 给你一个二维 二进制 数组 grid。请你找出一个边在水平方向和竖直方向上、面积 最小 的矩形，并且满足 grid 中所有的 1 都在矩形的内部。
 * <p>
 * 返回这个矩形可能的 最小 面积。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入： grid = [[0,1,0],[1,0,1]]
 * <p>
 * <p>
 * 输出： 6
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 这个最小矩形的高度为 2，宽度为 3，因此面积为 2 * 3 = 6。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入： grid = [[0,0],[1,0]]
 * <p>
 * <p>
 * 输出： 1
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 这个最小矩形的高度和宽度都是 1，因此面积为 1 * 1 = 1。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= grid.length, grid[i].length <= 1000
 * grid[i][j] 是 0 或 1。
 * 输入保证 grid 中至少有一个 1 。
 * <p>
 * <p>
 * Related Topics 数组 矩阵 👍 18 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumArea(int[][] grid) {
        int left = grid[0].length - 1, right = 0, top = grid.length - 1, down = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int l = 0; l < grid[i].length; l++) {
                if (grid[i][l] == 1) {
                    left = Math.min(left, l);
                    right = Math.max(right, l);
                    top = Math.min(top, i);
                    down = Math.max(down, i);
                }
            }
        }
        return (right - left + 1) * (down - top + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

