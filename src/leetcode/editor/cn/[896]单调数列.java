// 开始时间：2023-10-10 19:13:54
// 题目标题：单调数列
// 题目标记：monotonic-array
// 题目编号：896
// 题目描述：

/**
 * 如果数组是单调递增或单调递减的，那么它是 单调 的。
 * <p>
 * 如果对于所有 i <= j，nums[i] <= nums[j]，那么数组 nums 是单调递增的。 如果对于所有 i <= j，nums[i]> =
 * nums[j]，那么数组 nums 是单调递减的。
 * <p>
 * 当给定的数组 nums 是单调数组时返回 true，否则返回 false。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,2,2,3]
 * 输出：true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [6,5,4,4]
 * 输出：true
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [1,3,2]
 * 输出：false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁵
 * -10⁵ <= nums[i] <= 10⁵
 * <p>
 * <p>
 * Related Topics 数组 👍 197 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isMonotonic(int[] nums) {
        if (nums.length <= 1) {
            return true;
        }
        boolean flag = true;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[0]) {
                flag = nums[0] < nums[i];
            }
        }
        for (int i = 1; i < nums.length; i++) {
            if (flag && nums[i - 1] > nums[i]) {
                return false;
            } else if (!flag && nums[i - 1] < nums[i]) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

