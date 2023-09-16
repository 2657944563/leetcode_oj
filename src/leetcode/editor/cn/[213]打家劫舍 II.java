/*
打家劫舍 II
213
2023-09-16 11:20:11
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        // 1 t 0 bt
        return Math.max(tc(nums, 0, nums.length - 1), tc(nums, 1, nums.length));
    }

    int tc(int[] nums, int s, int e) {
        if (e == 0 || s >= nums.length) {
            return nums[0];
        }
        int[][] dp = new int[2][e];
        dp[0][s] = 0;
        dp[1][s] = nums[s];
        for (int i = 1; i < e; i++) {
            if (nums[i] + dp[0][i - 1] > dp[1][i - 1]) {
                dp[1][i] = nums[i] + dp[0][i - 1];
                dp[0][i] = dp[1][i - 1];
            } else {
                dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1]);
                dp[1][i] = dp[0][i];
            }
        }

        return Math.max(dp[0][e - 1], dp[1][e - 1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
