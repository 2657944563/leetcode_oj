// 开始时间：2023-10-10 22:39:33
// 题目标题：按奇偶排序数组 II
// 题目标记：sort-array-by-parity-ii
// 题目编号：922
// 题目描述：

/**
 * 给定一个非负整数数组 nums， nums 中一半整数是 奇数 ，一半整数是 偶数 。
 * <p>
 * 对数组进行排序，以便当 nums[i] 为奇数时，i 也是 奇数 ；当 nums[i] 为偶数时， i 也是 偶数 。
 * <p>
 * 你可以返回 任何满足上述条件的数组作为答案 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [2,3]
 * 输出：[2,3]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= nums.length <= 2 * 10⁴
 * nums.length 是偶数
 * nums 中一半是偶数
 * 0 <= nums[i] <= 1000
 * <p>
 * <p>
 * <p>
 * <p>
 * 进阶：可以不使用额外空间解决问题吗？
 * <p>
 * Related Topics 数组 双指针 排序 👍 281 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) != (nums[i] & 1)) {
                int l = i + 1;
                while (l < nums.length && (i & 1) != (nums[l] & 1)) {
                    l++;
                }
                nums[i] ^= nums[l];
                nums[l] ^= nums[i];
                nums[i] ^= nums[l];
            }
        }
        return nums;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

