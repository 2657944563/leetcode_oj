// 开始时间：2023-12-10 12:38:33
// 题目标题：爬楼梯
// 题目标记：climbing-stairs
// 题目编号：70
// 题目描述：

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 45
 * <p>
 * <p>
 * Related Topics 记忆化搜索 数学 动态规划 👍 3370 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int climbStairs(int n) {
        int i1 = 1, i2 = 2;
        if (n == 1) {
            return i1;
        } else if (n == 2) {
            return i2;
        }
        n -= 2;
        while (n-- >= 1) {
            i1 += i2;
            i1 ^= i2;
            i2 ^= i1;
            i1 ^= i2;
        }
        return i2;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

