// 开始时间：2023-10-17 23:03:15
// 题目标题：距离顺序排列矩阵单元格
// 题目标记：matrix-cells-in-distance-order
// 题目编号：1030
// 题目描述：

import java.util.Arrays;

/**
 * 给定四个整数 rows , cols , rCenter 和 cCenter 。有一个 rows x cols 的矩阵，你在单元格上的坐标是 (rCenter,
 * cCenter) 。
 * <p>
 * 返回矩阵中的所有单元格的坐标，并按与 (rCenter, cCenter) 的 距离 从最小到最大的顺序排。你可以按 任何 满足此条件的顺序返回答案。
 * <p>
 * 单元格(r1, c1) 和 (r2, c2) 之间的距离为|r1 - r2| + |c1 - c2|。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：rows = 1, cols = 2, rCenter = 0, cCenter = 0
 * 输出：[[0,0],[0,1]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：rows = 2, cols = 2, rCenter = 0, cCenter = 1
 * 输出：[[0,1],[0,0],[1,1],[1,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2]
 * [[0,1],[1,1],[0,0],[1,0]] 也会被视作正确答案。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：rows = 2, cols = 3, rCenter = 1, cCenter = 2
 * 输出：[[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
 * 解释：从 (r0, c0) 到其他单元格的距离为：[0,1,1,2,2,3]
 * 其他满足题目要求的答案也会被视为正确，例如 [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]]。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= rows, cols <= 100
 * 0 <= rCenter < rows
 * 0 <= cCenter < cols
 * <p>
 * <p>
 * Related Topics 几何 数组 数学 矩阵 排序 👍 151 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] result = new int[rows * cols][2];
        int m = 0;
        for (int i = 0; i < rows; i++) {
            for (int l = 0; l < cols; l++) {
                result[m++] = new int[]{i, l};
            }
        }
        Arrays.sort(result, (o1, o2) -> Math.abs(o1[0] - rCenter) + Math.abs(o1[1] - cCenter) - Math.abs(o2[0] - rCenter) - Math.abs(o2[1] - cCenter));
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

