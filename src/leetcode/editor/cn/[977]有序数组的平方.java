// 开始时间：2023-10-13 23:04:09
// 题目标题：有序数组的平方
// 题目标记：squares-of-a-sorted-array
// 题目编号：977
// 题目描述：

import java.util.Arrays;

/**
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 解释：平方后，数组变为 [16,1,0,9,100]
 * 排序后，数组变为 [0,1,9,16,100]
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁴
 * -10⁴ <= nums[i] <= 10⁴
 * nums 已按 非递减顺序 排序
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：
 * <p>
 * <p>
 * 请你设计时间复杂度为 O(n) 的算法解决本问题
 * <p>
 * <p>
 * Related Topics 数组 双指针 排序 👍 902 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        Arrays.sort(nums);
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

