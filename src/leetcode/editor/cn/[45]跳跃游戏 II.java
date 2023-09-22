// 开始时间：2023-09-22 10:27:09
// 题目标题：跳跃游戏 II
// 题目标记：jump-game-ii
// 题目编号：45
// 题目描述：

/**
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * <p>
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * <p>
 * <p>
 * 0 <= j <= nums[i]
 * i + j < n
 * <p>
 * <p>
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁴
 * 0 <= nums[i] <= 1000
 * 题目保证可以到达 nums[n-1]
 * <p>
 * <p>
 * Related Topics 贪心 数组 动态规划 👍 2280 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jump(int[] nums) {
        int l = 0, r = 0, max = nums[l], result = 0;
        while (r < nums.length - 1) {
            for (int m = l; m <= r; m++) {
                max = Math.max(nums[m] + m, max);
            }
            l = r + 1;
            r = max;
            result++;
            max = nums[l];
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

