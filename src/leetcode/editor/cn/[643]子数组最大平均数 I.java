// 开始时间：2023-09-24 19:01:11
// 题目标题：子数组最大平均数 I
// 题目标记：maximum-average-subarray-i
// 题目编号：643
// 题目描述：

/**
 * 给你一个由 n 个元素组成的整数数组 nums 和一个整数 k 。
 * <p>
 * 请你找出平均数最大且 长度为 k 的连续子数组，并输出该最大平均数。
 * <p>
 * 任何误差小于 10⁻⁵ 的答案都将被视为正确答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,12,-5,-6,50,3], k = 4
 * 输出：12.75
 * 解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [5], k = 1
 * 输出：5.00000
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * n == nums.length
 * 1 <= k <= n <= 10⁵
 * -10⁴ <= nums[i] <= 10⁴
 * <p>
 * <p>
 * Related Topics 数组 滑动窗口 👍 322 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double result = Integer.MIN_VALUE;
        double avg = 0L;
        for (int i = 0; i < k; i++) {
            avg += nums[i];
        }
        for (int i = 0; i < nums.length - k; i++) {
            result = Math.max(result, avg / k);
            avg = avg - nums[i] + nums[i + k];
        }
        return Math.max(result, avg / k);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

