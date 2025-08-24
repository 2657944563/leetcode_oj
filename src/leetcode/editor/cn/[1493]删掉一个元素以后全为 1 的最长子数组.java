// 开始时间：2025-08-24 20:48:54
// 题目标题：删掉一个元素以后全为 1 的最长子数组
// 题目标记：longest-subarray-of-1s-after-deleting-one-element
// 题目编号：1493
// 题目描述：

/**
 * 给你一个二进制数组 nums ，你需要从中删掉一个元素。
 * <p>
 * 请你在删掉元素的结果数组中，返回最长的且只包含 1 的非空子数组的长度。
 * <p>
 * 如果不存在这样的子数组，请返回 0 。
 * <p>
 * <p>
 * <p>
 * 提示 1：
 * <p>
 * <p>
 * 输入：nums = [1,1,0,1]
 * 输出：3
 * 解释：删掉位置 2 的数后，[1,1,1] 包含 3 个 1 。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [0,1,1,1,0,1,1,0,1]
 * 输出：5
 * 解释：删掉位置 4 的数字后，[0,1,1,1,1,1,0,1] 的最长全 1 子数组为 [1,1,1,1,1] 。
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [1,1,1]
 * 输出：2
 * 解释：你必须要删除一个元素。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁵
 * nums[i] 要么是 0 要么是 1 。
 * <p>
 * <p>
 * Related Topics 数组 动态规划 滑动窗口 👍 200 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestSubarray(int[] nums) {
        int[][] dp = new int[2][nums.length];
        dp[0][0] = 0;
        dp[1][nums.length - 1] = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[0][i] = nums[i - 1] + dp[0][i - 1];
            if (nums[i - 1] == 0) {
                dp[0][i] = 0;
            }
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            dp[1][i] = nums[i + 1] + dp[1][i + 1];
            if (nums[i + 1] == 0) {
                dp[1][i] = 0;
            }
        }
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            s = Math.max(s, dp[0][i] + dp[1][i]);
        }

        return s;


    }
}
//leetcode submit region end(Prohibit modification and deletion)

