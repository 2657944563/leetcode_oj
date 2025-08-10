// 开始时间：2025-08-09 21:21:04
// 题目标题：石子游戏
// 题目标记：stone-game
// 题目编号：877
// 题目描述：

/**
 * Alice 和 Bob 用几堆石子在做游戏。一共有偶数堆石子，排成一行；每堆都有 正 整数颗石子，数目为 piles[i] 。
 * <p>
 * 游戏以谁手中的石子最多来决出胜负。石子的 总数 是 奇数 ，所以没有平局。
 * <p>
 * Alice 和 Bob 轮流进行，Alice 先开始 。 每回合，玩家从行的 开始 或 结束 处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手
 * 中 石子最多 的玩家 获胜 。
 * <p>
 * 假设 Alice 和 Bob 都发挥出最佳水平，当 Alice 赢得比赛时返回 true ，当 Bob 赢得比赛时返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：piles = [5,3,4,5]
 * 输出：true
 * 解释：
 * Alice 先开始，只能拿前 5 颗或后 5 颗石子 。
 * 假设他取了前 5 颗，这一行就变成了 [3,4,5] 。
 * 如果 Bob 拿走前 3 颗，那么剩下的是 [4,5]，Alice 拿走后 5 颗赢得 10 分。
 * 如果 Bob 拿走后 5 颗，那么剩下的是 [3,4]，Alice 拿走后 4 颗赢得 9 分。
 * 这表明，取前 5 颗石子对 Alice 来说是一个胜利的举动，所以返回 true 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：piles = [3,7,2,3]
 * 输出：true
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= piles.length <= 500
 * piles.length 是 偶数
 * 1 <= piles[i] <= 500
 * sum(piles[i]) 是 奇数
 * <p>
 * <p>
 * Related Topics 数组 数学 动态规划 博弈 👍 558 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean stoneGame(int[] piles) {
        int[][] dp = new int[piles.length][piles.length];

        for (int i = 0; i < piles.length; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = 1; i < piles.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                dp[i][j] = Math.max(dp[i][i] - dp[i - 1][j], dp[j][j] - dp[i][j + 1]);
            }
        }
        return dp[piles.length - 1][0] > 0;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

