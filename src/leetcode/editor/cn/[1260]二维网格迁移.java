// 开始时间：2023-10-25 21:46:33
// 题目标题：二维网格迁移
// 题目标记：shift-2d-grid
// 题目编号：1260
// 题目描述：

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
 * <p>
 * 每次「迁移」操作将会引发下述活动：
 * <p>
 * <p>
 * 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
 * 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
 * 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
 * <p>
 * <p>
 * 请你返回 k 次迁移操作后最终得到的 二维网格。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * 输出：[[9,1,2],[3,4,5],[6,7,8]]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
 * 输出：[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
 * 输出：[[1,2,3],[4,5,6],[7,8,9]]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * m == grid.length
 * n == grid[i].length
 * 1 <= m <= 50
 * 1 <= n <= 50
 * -1000 <= grid[i][j] <= 1000
 * 0 <= k <= 100
 * <p>
 * <p>
 * Related Topics 数组 矩阵 模拟 👍 125 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> shiftGrid(int[][] g, int k) {
        int n = g.length, m = g[0].length;
        int[][] mat = new int[n][m];
        for (int i = 0; i < m; i++) {
            int tcol = (i + k) % m, trow = ((i + k) / m) % n, idx = 0;
            while (idx != n) mat[(trow++) % n][tcol] = g[idx++][i];
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> alist = new ArrayList<>();
            for (int j = 0; j < m; j++) alist.add(mat[i][j]);
            ans.add(alist);
        }
        return ans;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

