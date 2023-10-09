// 开始时间：2023-10-09 15:20:58
// 题目标题：螺旋矩阵 II
// 题目标记：spiral-matrix-ii
// 题目编号：59
// 题目描述：

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 1
 * 输出：[[1]]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 20
 * <p>
 * <p>
 * Related Topics 数组 矩阵 模拟 👍 1177 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int top = 0, down = n - 1, left = 0, right = n - 1;
        int i = 1, flag = 1, x = 0, y = 0;
        while (i <= n * n) {
            switch (flag) {
                case 1:
                    result[x][y] = i;
                    if (y == right) {
                        flag = 2;
                        top++;
                        x++;
                    } else {
                        y++;
                    }
                    break;
                case 2:
                    result[x][y] = i;
                    if (x == down) {
                        flag = 3;
                        right--;
                        y--;
                    } else {
                        x++;
                    }
                    break;
                case 3:
                    result[x][y] = i;
                    if (y == left) {
                        flag = 4;
                        down--;
                        x--;
                    } else {
                        y--;
                    }
                    break;
                default:
                    result[x][y] = i;
                    if (x == top) {
                        flag = 1;
                        left++;
                        y++;
                    } else {
                        x--;
                    }
            }
            i++;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

