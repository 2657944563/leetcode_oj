// 开始时间：2023-10-04 12:30:22
// 题目标题：买卖股票的最佳时机 IV
// 题目标记：best-time-to-buy-and-sell-stock-iv
// 题目编号：188
// 题目描述：

/**
 * 给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：k = 2, prices = [2,4,1]
 * 输出：2
 * 解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：k = 2, prices = [3,2,6,5,0,3]
 * 输出：7
 * 解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
 * 随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= k <= 100
 * 1 <= prices.length <= 1000
 * 0 <= prices[i] <= 1000
 * <p>
 * <p>
 * Related Topics 数组 动态规划 👍 1059 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        k = Math.min(k, n / 2);
        int[][] buy = new int[n][k + 1];
        int[][] sell = new int[n][k + 1];

        buy[0][0] = -prices[0];
        sell[0][0] = 0;
        for (int i = 1; i <= k; ++i) {
            buy[0][i] = sell[0][i] = Integer.MIN_VALUE / 2;
        }

        for (int i = 1; i < n; ++i) {
            buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
            for (int j = 1; j <= k; ++j) {
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);
            }
        }

        return Arrays.stream(sell[n - 1]).max().getAsInt();
    }
}

//leetcode submit region end(Prohibit modification and deletion)

