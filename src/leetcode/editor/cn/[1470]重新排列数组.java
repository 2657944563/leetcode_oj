// 开始时间：2025-08-16 21:56:55
// 题目标题：重新排列数组
// 题目标记：shuffle-the-array
// 题目编号：1470
// 题目描述：

/**
 * 给你一个数组 nums ，数组中有 2n 个元素，按 [x1,x2,...,xn,y1,y2,...,yn] 的格式排列。
 * <p>
 * 请你将数组按 [x1,y1,x2,y2,...,xn,yn] 格式重新排列，返回重排后的数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,5,1,3,4,7], n = 3
 * 输出：[2,3,5,4,1,7]
 * 解释：由于 x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 ，所以答案为 [2,3,5,4,1,7]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4,4,3,2,1], n = 4
 * 输出：[1,4,2,3,3,2,4,1]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,2,2], n = 2
 * 输出：[1,2,1,2]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 500
 * nums.length == 2n
 * 1 <= nums[i] <= 10^3
 * <p>
 * <p>
 * Related Topics 数组 👍 227 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[nums.length];
        int l = 0;
        for (int i = 0; i < nums.length - n; i++) {
            result[l++] = nums[i];
            result[l++] = nums[i + n];
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

