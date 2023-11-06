// 开始时间：2023-11-03 20:42:07
// 题目标题：矩阵中的幸运数
// 题目标记：lucky-numbers-in-a-matrix
// 题目编号：1380
// 题目描述：

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
 * <p>
 * 幸运数 是指矩阵中满足同时下列两个条件的元素：
 * <p>
 * <p>
 * 在同一行的所有元素中最小
 * 在同一列的所有元素中最大
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
 * 输出：[15]
 * 解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
 * 输出：[12]
 * 解释：12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：matrix = [[7,8],[1,2]]
 * 输出：[7]
 * 解释：7是唯一的幸运数字，因为它是行中的最小值，列中的最大值。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= n, m <= 50
 * 1 <= matrix[i][j] <= 10^5
 * 矩阵中的所有元素都是不同的
 * <p>
 * <p>
 * Related Topics 数组 矩阵 👍 135 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        LinkedList<Integer> list = new LinkedList<>();
        HashSet<Integer> hs = new HashSet<>();
        for (int[] ints : matrix) {
            int min = ints[0];
            for (int anInt : ints) {
                min = Math.min(min, anInt);
            }
            hs.add(min);
        }
        for (int i = 0; i < matrix[0].length; i++) {
            int max = matrix[0][i];
            for (int l = 0; l < matrix.length; l++) {
                max = Math.max(max, matrix[l][i]);
            }
            if (hs.contains(max)) {
                list.add(max);
            }
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

