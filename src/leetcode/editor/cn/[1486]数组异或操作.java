// 开始时间：2025-08-18 21:34:50
// 题目标题：数组异或操作
// 题目标记：xor-operation-in-an-array
// 题目编号：1486
// 题目描述：

/**
 * 给你两个整数，n 和 start 。
 * <p>
 * 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
 * <p>
 * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5, start = 0
 * 输出：8
 * 解释：数组 nums 为 [0, 2, 4, 6, 8]，其中 (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8 。
 * "^" 为按位异或 XOR 运算符。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 4, start = 3
 * 输出：8
 * 解释：数组 nums 为 [3, 5, 7, 9]，其中 (3 ^ 5 ^ 7 ^ 9) = 8.
 * <p>
 * 示例 3：
 * <p>
 * 输入：n = 1, start = 7
 * 输出：7
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * 输入：n = 10, start = 5
 * 输出：2
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 1000
 * 0 <= start <= 1000
 * n == nums.length
 * <p>
 * <p>
 * Related Topics 位运算 数学 👍 202 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int xorOperation(int n, int start) {
        int result = start;
        for (int i = 1; i < n; i++) {
            result ^= start + 2 * i;
        }
        return result;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

