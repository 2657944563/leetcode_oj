// 开始时间：2023-12-01 12:53:18
// 题目标题：找出叠涂元素
// 题目标记：first-completely-painted-row-or-column
// 题目编号：2661
// 题目描述：

import java.util.Arrays;

/**
 * 给你一个下标从 0 开始的整数数组 arr 和一个 m x n 的整数 矩阵 mat 。arr 和 mat 都包含范围 [1，m * n] 内的 所有 整数。
 * <p>
 * <p>
 * 从下标 0 开始遍历 arr 中的每个下标 i ，并将包含整数 arr[i] 的 mat 单元格涂色。
 * <p>
 * 请你找出 arr 中在 mat 的某一行或某一列上都被涂色且下标最小的元素，并返回其下标 i 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：arr = [1,3,4,2], mat = [[1,4],[2,3]]
 * 输出：2
 * 解释：遍历如上图所示，arr[2] 在矩阵中的第一行或第二列上都被涂色。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：arr = [2,8,7,4,1,3,5,6,9], mat = [[3,2,5],[1,4,6],[8,7,9]]
 * 输出：3
 * 解释：遍历如上图所示，arr[3] 在矩阵中的第二列上都被涂色。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * m == mat.length
 * n = mat[i].length
 * arr.length == m * n
 * 1 <= m, n <= 10⁵
 * 1 <= m * n <= 10⁵
 * 1 <= arr[i], mat[r][c] <= m * n
 * arr 中的所有整数 互不相同
 * mat 中的所有整数 互不相同
 * <p>
 * <p>
 * Related Topics 数组 哈希表 矩阵 👍 43 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length, m = mat[0].length;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map.put(mat[i][j], new int[]{i, j});
            }
        }
        int[] c1 = new int[n], c2 = new int[m];
        for (int i = 0; i < n * m; i++) {
            int[] info = map.get(arr[i]);
            int x = info[0], y = info[1];
            if (++c1[x] == m || ++c2[y] == n) return i;
        }
        return -1; // never
    }
}

//leetcode submit region end(Prohibit modification and deletion)

