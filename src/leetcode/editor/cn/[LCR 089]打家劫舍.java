// 开始时间：2023-09-19 16:53:15
// 题目标题：打家劫舍
// 题目标记：Gu0c2T
// 题目编号：LCR 089
// 题目描述：

/**
 * 一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响小偷偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷
 * 闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组 nums ，请计算 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 198 题相同： https://leetcode-cn.com/problems/house-robber/
 * Related Topics 数组 动态规划 👍 44 👎 0
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

