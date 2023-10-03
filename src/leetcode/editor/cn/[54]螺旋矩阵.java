// 开始时间：2023-09-30 15:09:25
// 题目标题：螺旋矩阵
// 题目标记：spiral-matrix
// 题目编号：54
// 题目描述：

import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 * <p>
 * <p>
 * Related Topics 数组 矩阵 模拟 👍 1498 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {
        LinkedList<Integer> result = new LinkedList<>();
        int top = 0, down = matrix.length - 1, right = matrix[0].length - 1, left = 0;
        int x = 0, y = 0, f = 0;
        while (x >= top && x <= down && y >= left && y <= right) {
            switch (f) {
                case 0:
                    result.add(matrix[x][y]);
                    if (y == right) {
                        f = 1;
                        x++;
                        top++;
                    } else {
                        y++;
                    }
                    break;
                case 1:
                    result.add(matrix[x][y]);
                    if (x == down) {
                        f = 2;
                        y--;
                        right--;
                    } else {
                        x++;
                    }
                    break;
                case 2:
                    result.add(matrix[x][y]);
                    if (y == left) {
                        f = 3;
                        x--;
                        down--;
                    } else {
                        y--;
                    }
                    break;
                case 3:
                    result.add(matrix[x][y]);
                    if (x == top) {
                        f = 0;
                        y++;
                        left++;
                    } else {
                        x--;
                    }
                    break;
                default:
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

