// 开始时间：2023-10-25 21:46:35
// 题目标题：整数的各位积和之差
// 题目标记：subtract-the-product-and-sum-of-digits-of-an-integer
// 题目编号：1281
// 题目描述：

/**
 * 给你一个整数 n，请你帮忙计算并返回该整数「各位数字之积」与「各位数字之和」的差。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 234
 * 输出：15
 * 解释：
 * 各位数之积 = 2 * 3 * 4 = 24
 * 各位数之和 = 2 + 3 + 4 = 9
 * 结果 = 24 - 9 = 15
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 4421
 * 输出：21
 * 解释：
 * 各位数之积 = 4 * 4 * 2 * 1 = 32
 * 各位数之和 = 4 + 4 + 2 + 1 = 11
 * 结果 = 32 - 11 = 21
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 10^5
 * <p>
 * <p>
 * Related Topics 数学 👍 162 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int subtractProductAndSum(int n) {
        int j = 1, c = 0, t = n;
        while (t > 0) {
            j *= t % 10;
            t /= 10;
        }
        while (n > 0) {
            c += n % 10;
            n /= 10;
        }
        return j - c;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

