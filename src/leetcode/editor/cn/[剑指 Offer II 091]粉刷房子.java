//粉刷房子
//剑指 Offer II 091
//2022-06-25 09:07:39
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                costs[i][j] = costs[i][j] + Math.min(costs[i - 1][(j + 1) % 3]
                        , costs[i - 1][(j + 2) % 3]);
            }
        }
        return Math.min(Math.min(costs[n - 1][0], costs[n - 1][1]), costs[n - 1][2]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
