// 开始时间：2025-08-22 21:23:15
// 题目标题：在区间范围内统计奇数数目
// 题目标记：count-odd-numbers-in-an-interval-range
// 题目编号：1523
// 题目描述：

/**
 * 给你两个非负整数 low 和 high 。请你返回 low 和 high 之间（包括二者）奇数的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：low = 3, high = 7
 * 输出：3
 * 解释：3 到 7 之间奇数数字为 [3,5,7] 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：low = 8, high = 10
 * 输出：1
 * 解释：8 到 10 之间奇数数字为 [9] 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= low <= high <= 10^9
 * <p>
 * <p>
 * Related Topics 数学 👍 128 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //    13 14 15 16 17 18
//    3 4 5 6 7
    public int countOdds(int low, int high) {
        if (low == high) {
            return low % 2;
        } else if (high - low == 1) {
            return 1;
        }
        int i = (high - low + 1) / 2;

        i = Math.max(i, 0);
        return i + (low % 2 == 1 && high - low > 1 ? (high - low + 1) % 2 : 0);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

