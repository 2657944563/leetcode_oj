// 开始时间：2023-09-19 17:30:15
// 题目标题：范围求和 II
// 题目标记：range-addition-ii
// 题目编号：598
// 题目描述：

/**
 * 给你一个 m x n 的矩阵 M ，初始化时所有的 0 和一个操作数组 op ，其中 ops[i] = [ai, bi] 意味着当所有的 0 <= x <
 * ai 和 0 <= y < bi 时， M[x][y] 应该加 1。
 * <p>
 * 在 执行完所有操作后 ，计算并返回 矩阵中最大整数的个数 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入: m = 3, n = 3，ops = [[2,2],[3,3]]
 * 输出: 4
 * 解释: M 中最大的整数是 2, 而且 M 中有4个值为2的元素。因此返回 4。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: m = 3, n = 3, ops = [[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3],[2,2],[
 * 3,3],[3,3],[3,3]]
 * 输出: 4
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入: m = 3, n = 3, ops = []
 * 输出: 9
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * <p>
 * <p>
 * 1 <= m, n <= 4 * 10⁴
 * 0 <= ops.length <= 10⁴
 * ops[i].length == 2
 * 1 <= ai <= m
 * 1 <= bi <= n
 * <p>
 * Related Topics 数组 数学 👍 201 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int minX = m, minY = n;
        int result = minX * minY;
        for (int[] op : ops) {
            if (op[0] < minX || op[1] < minY) {
                minX = Math.min(op[0], minX);
                minY = Math.min(op[1], minY);
                result = minX * minY;
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

