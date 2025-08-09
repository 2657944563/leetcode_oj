// 开始时间：2025-08-07 18:50:08
// 题目标题：检查平衡字符串
// 题目标记：check-balanced-string
// 题目编号：3340
// 题目描述：

/**
 * 给你一个仅由数字 0 - 9 组成的字符串 num。如果偶数下标处的数字之和等于奇数下标处的数字之和，则认为该数字字符串是一个 平衡字符串。
 * <p>
 * 如果 num 是一个 平衡字符串，则返回 true；否则，返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：num = "1234"
 * <p>
 * <p>
 * 输出：false
 * <p>
 * 解释：
 * <p>
 * <p>
 * 偶数下标处的数字之和为 1 + 3 = 4，奇数下标处的数字之和为 2 + 4 = 6。
 * 由于 4 不等于 6，num 不是平衡字符串。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：num = "24123"
 * <p>
 * <p>
 * 输出：true
 * <p>
 * 解释：
 * <p>
 * <p>
 * 偶数下标处的数字之和为 2 + 1 + 3 = 6，奇数下标处的数字之和为 4 + 2 = 6。
 * 由于两者相等，num 是平衡字符串。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= num.length <= 100
 * num 仅由数字 0 - 9 组成。
 * <p>
 * <p>
 * Related Topics 字符串 👍 23 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isBalanced(String num) {
        int sum = 0;
        for (int i = 0; i < num.getBytes().length; i++) {
            sum += (i % 2 == 1 ? -1 : 1) * (num.charAt(i) - '0');
        }
        return sum == 0;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

