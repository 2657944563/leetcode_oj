// 开始时间：2023-11-19 13:39:37
// 题目标题：三个无重叠子数组的最大和
// 题目标记：maximum-sum-of-3-non-overlapping-subarrays
// 题目编号：689
// 题目描述：

/**
 * 给你一个整数数组 nums 和一个整数 k ，找出三个长度为 k 、互不重叠、且全部数字和（3 * k 项）最大的子数组，并返回这三个子数组。
 * <p>
 * 以下标的数组形式返回结果，数组中的每一项分别指示每个子数组的起始位置（下标从 0 开始）。如果有多个结果，返回字典序最小的一个。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,2,1,2,6,7,5,1], k = 2
 * 输出：[0,3,5]
 * 解释：子数组 [1, 2], [2, 6], [7, 5] 对应的起始下标为 [0, 3, 5]。
 * 也可以取 [2, 1], 但是结果 [1, 3, 5] 在字典序上更大。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,2,1,2,1,2,1,2,1], k = 2
 * 输出：[0,2,4]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 2 * 10⁴
 * 1 <= nums[i] < 2¹⁶
 * 1 <= k <= floor(nums.length / 3)
 * <p>
 * <p>
 * Related Topics 数组 动态规划 👍 367 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int L = nums.length;
        int[] sum = new int[nums.length + 1];

        for (int i = 0; i < L; i++) {
            sum[i + 1] = i == 0 ? nums[i] : sum[i] + nums[i];
        }

        // value up to j-th element and with i sub-arrays
        int[][] dp = new int[4][L + 1];
        for (int i = 1; i < 4; i++) {
            for (int j = k; j <= L; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - k] + sum[j] - sum[j - k]);
            }
        }

        int[] ret = new int[3];
        int max = Arrays.stream(dp[3]).max().getAsInt();
        for (int i = 3; i >= 1; i--) {
            for (int j = 1; j <= L; j++) {
                if (dp[i][j] == max) {
                    ret[i - 1] = j - k;
                    max -= sum[j] - sum[j - k];
                }
            }
        }

        return ret;
    }
}

//leetcode submit region end(Prohibit modification and deletion)

