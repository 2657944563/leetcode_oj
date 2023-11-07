// 开始时间：2023-11-07 12:53:00
// 题目标题：是否所有 1 都至少相隔 k 个元素
// 题目标记：check-if-all-1s-are-at-least-length-k-places-away
// 题目编号：1437
// 题目描述：

/**
 * 给你一个由若干 0 和 1 组成的数组 nums 以及整数 k。如果所有 1 都至少相隔 k 个元素，则返回 True ；否则，返回 False 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：nums = [1,0,0,0,1,0,0,1], k = 2
 * 输出：true
 * 解释：每个 1 都至少相隔 2 个元素。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：nums = [1,0,0,1,0,1], k = 2
 * 输出：false
 * 解释：第二个 1 和第三个 1 之间只隔了 1 个元素。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,1,1,1], k = 0
 * 输出：true
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * 输入：nums = [0,1,0,1], k = 1
 * 输出：true
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 10^5
 * 0 <= k <= nums.length
 * nums[i] 的值为 0 或 1
 * <p>
 * <p>
 * Related Topics 数组 👍 32 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int i = 0;
        while (i < nums.length && nums[i] == 0) {
            i++;
        }
        for (; i < nums.length; ) {
            i++;
            if (i < nums.length) {
                int n = 0;
                while (i < nums.length && nums[i] == 0) {
                    n++;
                    i++;
                }
                System.out.println(n);
                if (i < nums.length && n < k) {
                    return false;
                }
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

