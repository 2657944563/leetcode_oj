// 开始时间：2023-11-07 12:52:57
// 题目标题：逐步求和得到正数的最小值
// 题目标记：minimum-value-to-get-positive-step-by-step-sum
// 题目编号：1413
// 题目描述：

/**
 * 给你一个整数数组 nums 。你可以选定任意的 正数 startValue 作为初始值。
 * <p>
 * 你需要从左到右遍历 nums 数组，并将 startValue 依次累加上 nums 数组中的值。
 * <p>
 * 请你在确保累加和始终大于等于 1 的前提下，选出一个最小的 正数 作为 startValue 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [-3,2,-3,4,2]
 * 输出：5
 * 解释：如果你选择 startValue = 4，在第三次累加时，和小于 1 。
 * 累加求和
 *                 startValue = 4 | startValue = 5 | nums
 *                   (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
 *                   (1 +2 ) = 3  | (2 +2 ) = 4    |   2
 *                   (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
 *                   (0 +4 ) = 4  | (1 +4 ) = 5    |   4
 *                   (4 +2 ) = 6  | (5 +2 ) = 7    |   2
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,2]
 * 输出：1
 * 解释：最小的 startValue 需要是正数。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [1,-2,-3]
 * 输出：5
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 * <p>
 * <p>
 * Related Topics 数组 前缀和 👍 115 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minStartValue(int[] nums) {
        int i = 0, sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum < 1) {
                i += 1 - sum;
                sum = 1;
            }
        }
        return i == 0 ? 1 : i;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

