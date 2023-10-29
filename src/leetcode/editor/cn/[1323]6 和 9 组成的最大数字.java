// 开始时间：2023-10-29 14:51:20
// 题目标题：6 和 9 组成的最大数字
// 题目标记：maximum-69-number
// 题目编号：1323
// 题目描述：

/**
 * 给你一个仅由数字 6 和 9 组成的正整数 num。
 * <p>
 * 你最多只能翻转一位数字，将 6 变成 9，或者把 9 变成 6 。
 * <p>
 * 请返回你可以得到的最大数字。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 9669
 * 输出：9969
 * 解释：
 * 改变第一位数字可以得到 6669 。
 * 改变第二位数字可以得到 9969 。
 * 改变第三位数字可以得到 9699 。
 * 改变第四位数字可以得到 9666 。
 * 其中最大的数字是 9969 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：num = 9996
 * 输出：9999
 * 解释：将最后一位从 6 变到 9，其结果 9999 是最大的数。
 * <p>
 * 示例 3：
 * <p>
 * 输入：num = 9999
 * 输出：9999
 * 解释：无需改变就已经是最大的数字了。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= num <= 10^4
 * num 每一位上的数字都是 6 或者 9 。
 * <p>
 * <p>
 * Related Topics 贪心 数学 👍 85 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximum69Number(int num) {
        int i = 3;
        for (; i >= 0; i--) {
            if (num / (int) Math.pow(10, i) % 10 == 6) {
                num += Math.pow(10, i) * 3;
                break;
            }
        }
        return num;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

