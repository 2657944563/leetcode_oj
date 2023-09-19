// 开始时间：2023-09-19 16:52:51
// 题目标题：打家劫舍 II
// 题目标记：PzWKhm
// 题目编号：LCR 090
// 题目描述：

/**
 * 一个专业的小偷，计划偷窃一个环形街道上沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，
 * 相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组 nums ，请计算 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [0]
 * 输出：0
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 213 题相同： https://leetcode-cn.com/problems/house-robber-ii/
 * Related Topics 数组 动态规划 👍 51 👎 0
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

