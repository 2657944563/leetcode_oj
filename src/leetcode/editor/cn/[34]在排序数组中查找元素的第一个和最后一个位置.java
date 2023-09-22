// 开始时间：2023-09-22 11:27:51
// 题目标题：在排序数组中查找元素的第一个和最后一个位置
// 题目标记：find-first-and-last-position-of-element-in-sorted-array
// 题目编号：34
// 题目描述：

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= nums.length <= 10⁵
 * -10⁹ <= nums[i] <= 10⁹
 * nums 是一个非递减数组
 * -10⁹ <= target <= 10⁹
 * <p>
 * <p>
 * Related Topics 数组 二分查找 👍 2475 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int l = -1, r = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                l = l != -1 ? l : i;
                r = i;
            }
            if (target < nums[i]) {
                return new int[]{l, r};
            }
        }
        return new int[]{l, r};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

