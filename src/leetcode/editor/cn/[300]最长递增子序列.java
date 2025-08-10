// 开始时间：2025-08-10 09:37:34
// 题目标题：最长递增子序列
// 题目标记：longest-increasing-subsequence
// 题目编号：300
// 题目描述：

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列
 * 。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 2500
 * -10⁴ <= nums[i] <= 10⁴
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * <p>
 * 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
 * <p>
 * <p>
 * Related Topics 数组 二分查找 动态规划 👍 4036 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 1;
        Arrays.fill(dp, 1);
        for (int i = nums.length - 2; i >= 0; i--) {
            for (int l = i + 1; l < nums.length; l++) {
                if (nums[i] < nums[l] && dp[i] < dp[l] + 1) {
                    dp[i] = 1 + dp[l];
                    max = Math.max(max, dp[i]);
                }
            }
        }
        return max;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

