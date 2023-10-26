// 开始时间：2023-10-26 11:44:11
// 题目标题：统计能整除数字的位数
// 题目标记：count-the-digits-that-divide-a-number
// 题目编号：2520
// 题目描述：

/**
 * 给你一个整数 num ，返回 num 中能整除 num 的数位的数目。
 * <p>
 * 如果满足 nums % val == 0 ，则认为整数 val 可以整除 nums 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 7
 * 输出：1
 * 解释：7 被自己整除，因此答案是 1 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：num = 121
 * 输出：2
 * 解释：121 可以被 1 整除，但无法被 2 整除。由于 1 出现两次，所以返回 2 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：num = 1248
 * 输出：4
 * 解释：1248 可以被它每一位上的数字整除，因此答案是 4 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= num <= 10⁹
 * num 的数位中不含 0
 * <p>
 * <p>
 * Related Topics 数学 👍 27 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countDigits(int num) {
        int sum = 0, t = num;

        while (t > 0) {
            if (num % (t % 10) == 0) {
                sum++;
            }
            t /= 10;
        }
        return sum;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

