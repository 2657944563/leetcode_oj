// 开始时间：2023-09-25 12:52:28
// 题目标题：跳跃游戏
// 题目标记：jump-game
// 题目编号：55
// 题目描述：

/**
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁴
 * 0 <= nums[i] <= 10⁵
 * <p>
 * <p>
 * Related Topics 贪心 数组 动态规划 👍 2513 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean canJump(int[] nums) {
        int max = nums[0];
        for (int l = 0; l <= max; l++) {
            max = Math.max(max, l + nums[l]);
            if (max >= nums.length - 1) {
                return true;
            }
        }
        return nums.length == 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

