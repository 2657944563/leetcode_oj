// 开始时间：2023-11-21 21:08:40
// 题目标题：美化数组的最少删除数
// 题目标记：minimum-deletions-to-make-array-beautiful
// 题目编号：2216
// 题目描述：

import java.util.Stack;

/**
 * 给你一个下标从 0 开始的整数数组 nums ，如果满足下述条件，则认为数组 nums 是一个 美丽数组 ：
 * <p>
 * <p>
 * nums.length 为偶数
 * 对所有满足 i % 2 == 0 的下标 i ，nums[i] != nums[i + 1] 均成立
 * <p>
 * <p>
 * 注意，空数组同样认为是美丽数组。
 * <p>
 * 你可以从 nums 中删除任意数量的元素。当你删除一个元素时，被删除元素右侧的所有元素将会向左移动一个单位以填补空缺，而左侧的元素将会保持 不变 。
 * <p>
 * 返回使 nums 变为美丽数组所需删除的 最少 元素数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2,3,5]
 * 输出：1
 * 解释：可以删除 nums[0] 或 nums[1] ，这样得到的 nums = [1,2,3,5] 是一个美丽数组。可以证明，要想使 nums 变为美丽数组，至
 * 少需要删除 1 个元素。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,2,2,3,3]
 * 输出：2
 * 解释：可以删除 nums[0] 和 nums[5] ，这样得到的 nums = [1,2,2,3] 是一个美丽数组。可以证明，要想使 nums 变为美丽数组，至
 * 少需要删除 2 个元素。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10⁵
 * 0 <= nums[i] <= 10⁵
 * <p>
 * <p>
 * Related Topics 栈 贪心 数组 👍 93 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minDeletion(int[] nums) {
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            if (stack.isEmpty()) {
                stack.push(num);
            } else if (stack.peek() != num) {
                stack.pop();
            } else {
                i++;
            }
        }
        if (!stack.isEmpty()) {
            i++;
        }
        return i;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

