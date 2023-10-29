// 开始时间：2023-10-29 14:51:19
// 题目标题：将整数转换为两个无零整数的和
// 题目标记：convert-integer-to-the-sum-of-two-no-zero-integers
// 题目编号：1317
// 题目描述：

/**
 * 「无零整数」是十进制表示中 不含任何 0 的正整数。
 * <p>
 * 给你一个整数 n，请你返回一个 由两个整数组成的列表 [A, B]，满足：
 * <p>
 * <p>
 * A 和 B 都是无零整数
 * A + B = n
 * <p>
 * <p>
 * 题目数据保证至少有一个有效的解决方案。
 * <p>
 * 如果存在多个有效解决方案，你可以返回其中任意一个。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：[1,1]
 * 解释：A = 1, B = 1. A + B = n 并且 A 和 B 的十进制表示形式都不包含任何 0 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 11
 * 输出：[2,9]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：n = 10000
 * 输出：[1,9999]
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * 输入：n = 69
 * 输出：[1,68]
 * <p>
 * <p>
 * 示例 5：
 * <p>
 * 输入：n = 1010
 * 输出：[11,999]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= n <= 10^4
 * <p>
 * <p>
 * Related Topics 数学 👍 35 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] getNoZeroIntegers(int n) {
        int[] result = new int[2];
        for (int i = 1; i < n; i++) {
            if (check(i) && check(n - i)) {
                result[0] = i;
                result[1] = n - i;
                break;
            }
        }
        return result;
    }

    boolean check(int i) {
        while (i > 0) {
            if (i % 10 == 0) {
                return false;
            }
            i /= 10;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

