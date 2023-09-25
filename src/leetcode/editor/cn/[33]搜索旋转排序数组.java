// 开始时间：2023-09-25 12:09:46
// 题目标题：搜索旋转排序数组
// 题目标记：search-in-rotated-sorted-array
// 题目编号：33
// 题目描述：

import java.util.Arrays;

/**
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+
 * 1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4
 * ,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 * <p>
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [1], target = 0
 * 输出：-1
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 5000
 * -10⁴ <= nums[i] <= 10⁴
 * nums 中的每个值都 独一无二
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -10⁴ <= target <= 10⁴
 * <p>
 * <p>
 * Related Topics 数组 二分查找 👍 2746 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        if (nums[0] < nums[nums.length - 1]) {
            int i = Arrays.binarySearch(nums, target);
            return i < 0 ? -1 : i;
        }

        int l = nums.length;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                l = i;
                break;
            }
        }
        if (target >= nums[0]) {
            int i = Arrays.binarySearch(nums, 0, l, target);
            return i < 0 ? -1 : i;
        }
        int i = Arrays.binarySearch(nums, l, nums.length, target);
        return i < 0 ? -1 : i;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

