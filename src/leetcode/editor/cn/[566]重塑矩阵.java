// 开始时间：2023-09-19 17:30:13
// 题目标题：重塑矩阵
// 题目标记：reshape-the-matrix
// 题目编号：566
// 题目描述：

import java.util.ArrayList;

/**
 * 在 MATLAB 中，有一个非常有用的函数 reshape ，它可以将一个 m x n 矩阵重塑为另一个大小不同（r x c）的新矩阵，但保留其原始数据。
 * <p>
 * 给你一个由二维数组 mat 表示的 m x n 矩阵，以及两个正整数 r 和 c ，分别表示想要的重构的矩阵的行数和列数。
 * <p>
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的 行遍历顺序 填充。
 * <p>
 * 如果具有给定参数的 reshape 操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：mat = [[1,2],[3,4]], r = 1, c = 4
 * 输出：[[1,2,3,4]]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：mat = [[1,2],[3,4]], r = 2, c = 4
 * 输出：[[1,2],[3,4]]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 100
 * -1000 <= mat[i][j] <= 1000
 * 1 <= r, c <= 300
 * <p>
 * Related Topics 数组 矩阵 模拟 👍 410 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if (r * c != mat.length * mat[0].length) {
            return mat;
        }
        int[][] result = new int[r][c];
        ArrayList<Integer> list = new ArrayList<>(mat.length * mat[0].length);
        for (int[] ints : mat) {
            for (int anInt : ints) {
                list.add(anInt);
            }
        }
        int flag = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = list.get(flag++);
            }
        }
        return result;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

