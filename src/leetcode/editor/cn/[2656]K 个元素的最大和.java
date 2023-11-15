// 开始时间：2023-11-15 16:39:19
// 题目标题：K 个元素的最大和
// 题目标记：maximum-sum-with-exactly-k-elements
// 题目编号：2656
// 题目描述：

import java.util.Arrays;

/**
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。你需要执行以下操作 恰好 k 次，最大化你的得分：
 * <p>
 * <p>
 * 从 nums 中选择一个元素 m 。
 * 将选中的元素 m 从数组中删除。
 * 将新元素 m + 1 添加到数组中。
 * 你的得分增加 m 。
 * <p>
 * <p>
 * 请你返回执行以上操作恰好 k 次后的最大得分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,2,3,4,5], k = 3
 * 输出：18
 * 解释：我们需要从 nums 中恰好选择 3 个元素并最大化得分。
 * 第一次选择 5 。和为 5 ，nums = [1,2,3,4,6] 。
 * 第二次选择 6 。和为 6 ，nums = [1,2,3,4,7] 。
 * 第三次选择 7 。和为 5 + 6 + 7 = 18 ，nums = [1,2,3,4,8] 。
 * 所以我们返回 18 。
 * 18 是可以得到的最大答案。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [5,5,5], k = 2
 * 输出：11
 * 解释：我们需要从 nums 中恰好选择 2 个元素并最大化得分。
 * 第一次选择 5 。和为 5 ，nums = [5,5,6] 。
 * 第二次选择 6 。和为 6 ，nums = [5,5,7] 。
 * 所以我们返回 11 。
 * 11 是可以得到的最大答案。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * 1 <= k <= 100
 * <p>
 * <p>
 * Related Topics 贪心 数组 👍 41 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximizeSum(int[] nums, int k) {
        int m = Arrays.stream(nums).max().orElse(0);
        int result = 0;
        for (int i = 0; i < k; i++) {
            result += m++;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

