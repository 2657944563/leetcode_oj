// 开始时间：2023-10-10 19:13:54
// 题目标题：三维形体的表面积
// 题目标记：surface-area-of-3d-shapes
// 题目编号：892
// 题目描述：

/**
 * 给你一个 n * n 的网格 grid ，上面放置着一些 1 x 1 x 1 的正方体。每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格
 * (i, j) 上。
 * <p>
 * 放置好正方体后，任何直接相邻的正方体都会互相粘在一起，形成一些不规则的三维形体。
 * <p>
 * 请你返回最终这些形体的总表面积。
 * <p>
 * 注意：每个形体的底面也需要计入表面积中。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：grid = [[1,2],[3,4]]
 * 输出：34
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：32
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：grid = [[2,2,2],[2,1,2],[2,2,2]]
 * 输出：46
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * n == grid.length
 * n == grid[i].length
 * 1 <= n <= 50
 * 0 <= grid[i][j] <= 50
 * <p>
 * <p>
 * Related Topics 几何 数组 数学 矩阵 👍 178 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int surfaceArea(int[][] grid) {
        int area = grid.length * grid.length * 2;
        for (int i = 0; i < grid.length; i++) {
            for (int l = 0; l < grid[i].length; l++) {
                area += grid[i][l] == 0 ? -2 : getArea(grid, i, l);
                //System.out.println(area);
            }
        }
        return area;
    }

    int getArea(int[][] grid, int x, int y) {
        int area = 0;
        if (x > 0) {
            area += grid[x][y] < grid[x - 1][y] ? 0 : grid[x][y] - grid[x - 1][y];
        } else {
            area += grid[x][y];
        }
        if (y > 0) {
            area += grid[x][y] < grid[x][y - 1] ? 0 : grid[x][y] - grid[x][y - 1];
        } else {
            area += grid[x][y];
        }
        if (x < grid.length - 1) {
            area += grid[x][y] < grid[x + 1][y] ? 0 : grid[x][y] - grid[x + 1][y];
        } else {
            area += grid[x][y];
        }
        if (y < grid.length - 1) {
            area += grid[x][y] < grid[x][y + 1] ? 0 : grid[x][y] - grid[x][y + 1];
        } else {
            area += grid[x][y];
        }
        return area;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

