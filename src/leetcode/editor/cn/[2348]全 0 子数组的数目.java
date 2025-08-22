// 开始时间：2025-08-19 18:20:24
// 题目标题：全 0 子数组的数目
// 题目标记：number-of-zero-filled-subarrays
// 题目编号：2348
// 题目描述：

/**
 * 给你一个整数数组 nums ，返回全部为 0 的 子数组 数目。
 * <p>
 * 子数组 是一个数组中一段连续非空元素组成的序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,0,0,2,0,0,4]
 * 输出：6
 * 解释：
 * 子数组 [0] 出现了 4 次。
 * 子数组 [0,0] 出现了 2 次。
 * 不存在长度大于 2 的全 0 子数组，所以我们返回 6 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,0,2,0,0]
 * 输出：9
 * 解释：
 * 子数组 [0] 出现了 5 次。
 * 子数组 [0,0] 出现了 3 次。
 * 子数组 [0,0,0] 出现了 1 次。
 * 不存在长度大于 3 的全 0 子数组，所以我们返回 9 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [2,10,2019]
 * 输出：0
 * 解释：没有全 0 子数组，所以我们返回 0 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁵
 * -10⁹ <= nums[i] <= 10⁹
 * <p>
 * <p>
 * Related Topics 数组 数学 👍 40 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public long zeroFilledSubarray(int[] nums) {

        long s = 0;
        for (int i = 0, l = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                l++;
                s += l;
            } else {
                l = 0;
            }
        }
        return s;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

