// 开始时间：2025-08-22 21:17:30
// 题目标题：好数对的数目
// 题目标记：number-of-good-pairs
// 题目编号：1512
// 题目描述：

/**
 * 给你一个整数数组 nums 。
 * <p>
 * 如果一组数字 (i,j) 满足 nums[i] == nums[j] 且 i < j ，就可以认为这是一组 好数对 。
 * <p>
 * 返回好数对的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,1,1,3]
 * 输出：4
 * 解释：有 4 组好数对，分别是 (0,3), (0,4), (3,4), (2,5) ，下标从 0 开始
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1,1]
 * 输出：6
 * 解释：数组中的每组数字都是好数对
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：0
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * <p>
 * <p>
 * Related Topics 数组 哈希表 数学 计数 👍 234 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numIdenticalPairs(int[] nums) {
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int l = i + 1; l < nums.length; l++) {
                s += nums[i] == nums[l] ? 1 : 0;
            }
        }
        return s;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

