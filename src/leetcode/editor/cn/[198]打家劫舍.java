/*
打家劫舍
198
2023-09-16 10:14:17
*/
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int rob(int[] nums) {
        // 1 t 0 bt
        int[][] dp = new int[2][nums.length];
        dp[0][0] = 0;
        dp[1][0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] + dp[0][i - 1] > dp[1][i - 1]) {
                dp[1][i] = nums[i] + dp[0][i - 1];
                dp[0][i] = dp[1][i - 1];
            } else {
                dp[0][i] = Math.max(dp[0][i - 1], dp[1][i - 1]);
                dp[1][i] = dp[0][i];
            }
        }

        return Math.max(dp[0][nums.length - 1], dp[1][nums.length - 1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
