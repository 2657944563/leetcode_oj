// 开始时间：2025-08-17 10:18:28
// 题目标题：新 21 点
// 题目标记：new-21-game
// 题目编号：837
// 题目描述：

/**
 * 爱丽丝参与一个大致基于纸牌游戏 “21点” 规则的游戏，描述如下：
 * <p>
 * 爱丽丝以 0 分开始，并在她的得分少于 k 分时抽取数字。 抽取时，她从 [1, maxPts] 的范围中随机获得一个整数作为分数进行累计，其中
 * maxPts 是一个整数。 每次抽取都是独立的，其结果具有相同的概率。
 * <p>
 * 当爱丽丝获得 k 分 或更多分 时，她就停止抽取数字。
 * <p>
 * 爱丽丝的分数不超过 n 的概率是多少？
 * <p>
 * 与实际答案误差不超过 10⁻⁵ 的答案将被视为正确答案。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 10, k = 1, maxPts = 10
 * 输出：1.00000
 * 解释：爱丽丝得到一张牌，然后停止。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 6, k = 1, maxPts = 10
 * 输出：0.60000
 * 解释：爱丽丝得到一张牌，然后停止。 在 10 种可能性中的 6 种情况下，她的得分不超过 6 分。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：n = 21, k = 17, maxPts = 10
 * 输出：0.73278
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= k <= n <= 10⁴
 * 1 <= maxPts <= 10⁴
 * <p>
 * <p>
 * Related Topics 数学 动态规划 滑动窗口 概率与统计 👍 412 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double new21Game(int n, int k, int maxPts) {
        if (k == 0) {
            return 1.0;
        }
        double[] dp = new double[k + maxPts];
        for (int i = k; i <= n && i < k + maxPts; i++) {
            dp[i] = 1.0;
        }
        dp[k - 1] = 1.0 * Math.min(n - k + 1, maxPts) / maxPts;
        for (int i = k - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] - (dp[i + maxPts + 1] - dp[i + 1]) / maxPts;
        }
        return dp[0];
    }
}

//leetcode submit region end(Prohibit modification and deletion)

