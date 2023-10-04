// 开始时间：2023-10-04 15:34:47
// 题目标题：托普利茨矩阵
// 题目标记：toeplitz-matrix
// 题目编号：766
// 题目描述：

/**
 * 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
 * <p>
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 * 输出：true
 * 解释：
 * 在上述矩阵中, 其对角线为:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
 * 各条对角线上的所有元素均相同, 因此答案是 True 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,2],[2,2]]
 * 输出：false
 * 解释：
 * 对角线 "[1, 2]" 上的元素不同。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 20
 * 0 <= matrix[i][j] <= 99
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * <p>
 * 如果矩阵存储在磁盘上，并且内存有限，以至于一次最多只能将矩阵的一行加载到内存中，该怎么办？
 * 如果矩阵太大，以至于一次只能将不完整的一行加载到内存中，该怎么办？
 * <p>
 * <p>
 * Related Topics 数组 矩阵 👍 299 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (!check(matrix, i, 0)) {
                return false;
            }
        }
        for (int i = 0; i < matrix[0].length; i++) {
            if (!check(matrix, 0, i)) {
                return false;
            }
        }

        return true;
    }

    boolean check(int[][] matrix, int x, int y) {
        int target = matrix[x][y];
        while (x < matrix.length && y < matrix[0].length) {
            if (matrix[x][y] != target) {
                return false;
            }
            x++;
            y++;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

