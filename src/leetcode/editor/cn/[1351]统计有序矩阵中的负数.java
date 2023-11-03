// 开始时间：2023-11-02 17:27:06
// 题目标题：统计有序矩阵中的负数
// 题目标记：count-negative-numbers-in-a-sorted-matrix
// 题目编号：1351
// 题目描述：

/**
 * 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。 请你统计并返回 grid 中 负数 的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
 * 输出：8
 * 解释：矩阵中共有 8 个负数。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：grid = [[3,2],[1,0]]
 * 输出：0
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 100
 * -100 <= grid[i][j] <= 100
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：你可以设计一个时间复杂度为 O(n + m) 的解决方案吗？
 * <p>
 * Related Topics 数组 二分查找 矩阵 👍 159 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countNegatives(int[][] grid) {
        int sum = 0;
        for (int[] ints : grid) {
            for (int anInt : ints) {
                if (anInt < 0) {
                    sum++;
                }
            }
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

