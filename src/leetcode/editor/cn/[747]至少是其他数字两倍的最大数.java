// 开始时间：2023-10-03 12:14:44
// 题目标题：至少是其他数字两倍的最大数
// 题目标记：largest-number-at-least-twice-of-others
// 题目编号：747
// 题目描述：

/**
 * 给你一个整数数组 nums ，其中总是存在 唯一的 一个最大整数 。
 * <p>
 * 请你找出数组中的最大元素并检查它是否 至少是数组中每个其他数字的两倍 。如果是，则返回 最大元素的下标 ，否则返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [3,6,1,0]
 * 输出：1
 * 解释：6 是最大的整数，对于数组中的其他整数，6 至少是数组中其他元素的两倍。6 的下标是 1 ，所以返回 1 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：-1
 * 解释：4 没有超过 3 的两倍大，所以返回 -1 。
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [1]
 * 输出：0
 * 解释：因为不存在其他数字，所以认为现有数字 1 至少是其他数字的两倍。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 50
 * 0 <= nums[i] <= 100
 * nums 中的最大元素是唯一的
 * <p>
 * <p>
 * Related Topics 数组 排序 👍 203 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int dominantIndex(int[] nums) {
        int i = 0, max = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] > max) {
                i = j;
                max = nums[j];
            }
        }
        for (int num : nums) {
            if (num != max && num * 2 > max) {
                return -1;
            }
        }
        return i;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

