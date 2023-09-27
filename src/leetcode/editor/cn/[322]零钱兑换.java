// 开始时间：2023-09-27 16:10:06
// 题目标题：零钱兑换
// 题目标记：coin-change
// 题目编号：322
// 题目描述：

import java.util.Arrays;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 2³¹ - 1
 * 0 <= amount <= 10⁴
 * <p>
 * <p>
 * Related Topics 广度优先搜索 数组 动态规划 👍 2586 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i >= coin) {
                    min = Math.min(min, dp[i - coin]);
                }
            }
            if (min != Integer.MAX_VALUE) {
                dp[i] = min + 1;
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

