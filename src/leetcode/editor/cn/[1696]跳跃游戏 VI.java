// 开始时间：2024-02-05 09:15:43
// 题目标题：跳跃游戏 VI
// 题目标记：jump-game-vi
// 题目编号：1696
// 题目描述：

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 * <p>
 * 一开始你在下标 0 处。每一步，你最多可以往前跳 k 步，但你不能跳出数组的边界。也就是说，你可以从下标 i 跳到 [i + 1， min(n - 1, i
 * + k)] 包含 两个端点的任意位置。
 * <p>
 * 你的目标是到达数组最后一个位置（下标为 n - 1 ），你的 得分 为经过的所有数字之和。
 * <p>
 * 请你返回你能得到的 最大得分 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [1,-1,-2,4,-7,3], k = 2
 * 输出：7
 * 解释：你可以选择子序列 [1,-1,4,3] （上面加粗的数字），和为 7 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [10,-5,-2,4,0,3], k = 3
 * 输出：17
 * 解释：你可以选择子序列 [10,4,3] （上面加粗数字），和为 17 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：nums = [1,-5,-20,4,-1,3,-6,-3], k = 2
 * 输出：0
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length, k <= 10⁵
 * -10⁴ <= nums[i] <= 10⁴
 * <p>
 * <p>
 * Related Topics 队列 数组 动态规划 单调队列 堆（优先队列） 👍 159 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxResult(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }
        int length = nums.length;
        // dp[i] = 到达i位置可得的最大分数
        int[] dp = new int[length];
        // 初始化除0外的所有值为最小
        dp[0] = nums[0];
        for (int i = 1; i < length; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        for (int i = 0; i < length; i++) {
            // dp[i]可到达的所有位置
            for (int j = i + 1; j < length && j <= i + k; j++) {
                // 从i跳跃到j位置, j位置的最大得分
                int nextNum = dp[i] + nums[j];
                // 如果比j位置当前最大得分大, 则更新j位置最大得分
                if (dp[j] < nextNum) {
                    dp[j] = nextNum;
                }
                // 剪枝, i后面能影响到的分数, 可以由遍历到j时进行更新
                if (dp[j] >= dp[i]) {
                    break;
                }
            }
        }
        return dp[length - 1];
    }
}

//leetcode submit region end(Prohibit modification and deletion)

