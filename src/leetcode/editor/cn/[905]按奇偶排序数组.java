// 开始时间：2023-10-10 19:13:56
// 题目标题：按奇偶排序数组
// 题目标记：sort-array-by-parity
// 题目编号：905
// 题目描述：

/**
 * 给你一个整数数组 nums，将 nums 中的的所有偶数元素移动到数组的前面，后跟所有奇数元素。
 * <p>
 * 返回满足此条件的 任一数组 作为答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [3,1,2,4]
 * 输出：[2,4,3,1]
 * 解释：[4,2,3,1]、[2,4,1,3] 和 [4,2,1,3] 也会被视作正确答案。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [0]
 * 输出：[0]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 5000
 * 0 <= nums[i] <= 5000
 * <p>
 * <p>
 * Related Topics 数组 双指针 排序 👍 371 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        for (int i = 0, l = nums.length - 1; i < l; i++) {
            if (nums[i] % 2 == 1) {
                while (l >= i && nums[l] % 2 != 0) {
                    if (l == i) {
                        return nums;
                    }
                    l--;
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

