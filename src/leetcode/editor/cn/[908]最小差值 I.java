// 开始时间：2023-10-10 22:39:31
// 题目标题：最小差值 I
// 题目标记：smallest-range-i
// 题目编号：908
// 题目描述：

/**
 * 给你一个整数数组 nums，和一个整数 k 。
 * <p>
 * 在一个操作中，您可以选择 0 <= i < nums.length 的任何索引 i 。将 nums[i] 改为 nums[i] + x ，其中 x 是一个范围
 * 为 [-k, k] 的整数。对于每个索引 i ，最多 只能 应用 一次 此操作。
 * <p>
 * nums 的 分数 是 nums 中最大和最小元素的差值。
 * <p>
 * 在对 nums 中的每个索引最多应用一次上述操作后，返回 nums 的最低 分数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1], k = 0
 * 输出：0
 * 解释：分数是 max(nums) - min(nums) = 1 - 1 = 0。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [0,10], k = 2
 * 输出：6
 * 解释：将 nums 改为 [2,8]。分数是 max(nums) - min(nums) = 8 - 2 = 6。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [1,3,6], k = 3
 * 输出：0
 * 解释：将 nums 改为 [4,4,4]。分数是 max(nums) - min(nums) = 4 - 4 = 0。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁴
 * 0 <= nums[i] <= 10⁴
 * 0 <= k <= 10⁴
 * <p>
 * <p>
 * Related Topics 数组 数学 👍 188 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int max = nums[0], min = max;
        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }
        return max - min > k * 2 ? (max - min) - k * 2 : 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

