// 开始时间：2023-10-24 12:16:00
// 题目标题：掷骰子等于目标和的方法数
// 题目标记：number-of-dice-rolls-with-target-sum
// 题目编号：1155
// 题目描述：

/**
 * 这里有 n 个一样的骰子，每个骰子上都有 k 个面，分别标号为 1 到 k 。
 * <p>
 * 给定三个整数 n , k 和 target ，返回可能的方式(从总共 kⁿ 种方式中)滚动骰子的数量，使正面朝上的数字之和等于 target 。
 * <p>
 * 答案可能很大，你需要对 10⁹ + 7 取模 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 1, k = 6, target = 3
 * 输出：1
 * 解释：你扔一个有 6 个面的骰子。
 * 得到 3 的和只有一种方法。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 2, k = 6, target = 7
 * 输出：6
 * 解释：你扔两个骰子，每个骰子有 6 个面。
 * 得到 7 的和有 6 种方法：1+6 2+5 3+4 4+3 5+2 6+1。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：n = 30, k = 30, target = 500
 * 输出：222616187
 * 解释：返回的结果必须是对 10⁹ + 7 取模。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n, k <= 30
 * 1 <= target <= 1000
 * <p>
 * <p>
 * Related Topics 动态规划 👍 217 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        final int mod = (int) (Math.pow(10, 9) + 7);
        // 打表
        int[][] dp = new int[n + 1][target + 1];
        // 赋值单个投掷能够打到的值
        for (int j = 1; j <= k && j <= target; j++) {
            dp[1][j] = 1;
        }
        // 处理每多一个投掷的值
        for (int i = 2; i < dp.length; i++) {
            // 每多一个投掷的值=当前投掷能够丢到的点数 - 对应已经被之前投掷丢到的次数总和
            for (int j = i; j <= target && j <= i * k; j++) {
                // 每个投掷能够投掷的区间
                for (int l = 1; l <= k && l < j; l++) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - l]) % mod;
                }
            }
        }
        // 返回所需要的值
        return dp[n][target];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

