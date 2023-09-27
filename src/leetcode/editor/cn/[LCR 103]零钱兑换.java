// 开始时间：2023-09-27 21:45:23
// 题目标题：零钱兑换
// 题目标记：gaM7Ch
// 题目编号：LCR 103
// 题目描述：

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -
 * 1。
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
 * 示例 4：
 * <p>
 * <p>
 * 输入：coins = [1], amount = 1
 * 输出：1
 * <p>
 * <p>
 * 示例 5：
 * <p>
 * <p>
 * 输入：coins = [1], amount = 2
 * 输出：2
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
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 322 题相同： https://leetcode-cn.com/problems/coin-change/
 * <p>
 * Related Topics 广度优先搜索 数组 动态规划 👍 94 👎 0
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

