// 开始时间：2023-10-26 15:19:30
// 题目标题：阶乘尾数
// 题目标记：factorial-zeros-lcci
// 题目编号：面试题 16.05
// 题目描述：

/**
 * 设计一个算法，算出 n 阶乘有多少个尾随零。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 3
 * 输出: 0
 * 解释: 3! = 6, 尾数中没有零。
 * <p>
 * 示例 2:
 * <p>
 * 输入: 5
 * 输出: 1
 * 解释: 5! = 120, 尾数中有 1 个零.
 * <p>
 * 说明: 你算法的时间复杂度应为 O(log n) 。
 * <p>
 * Related Topics 数学 👍 97 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trailingZeroes(int n) {
        int cnt = 0;
        for (long num = 5; n / num > 0; num *= 5) {
            cnt += n / num;
        }
        return cnt;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

