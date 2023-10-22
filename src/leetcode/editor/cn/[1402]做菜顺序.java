// 开始时间：2023-10-22 11:03:08
// 题目标题：做菜顺序
// 题目标记：reducing-dishes
// 题目编号：1402
// 题目描述：

import java.util.Arrays;

/**
 * 一个厨师收集了他 n 道菜的满意程度 satisfaction ，这个厨师做出每道菜的时间都是 1 单位时间。
 * <p>
 * 一道菜的 「 like-time 系数 」定义为烹饪这道菜结束的时间（包含之前每道菜所花费的时间）乘以这道菜的满意程度，也就是 time[i]*
 * satisfaction[i] 。
 * <p>
 * 返回厨师在准备了一定数量的菜肴后可以获得的最大 like-time 系数 总和。
 * <p>
 * 你可以按 任意 顺序安排做菜的顺序，你也可以选择放弃做某些菜来获得更大的总和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：satisfaction = [-1,-8,0,5,-9]
 * 输出：14
 * 解释：去掉第二道和最后一道菜，最大的 like-time 系数和为 (-1*1 + 0*2 + 5*3 = 14) 。每道菜都需要花费 1 单位时间完成。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：satisfaction = [4,3,2]
 * 输出：20
 * 解释：可以按照任意顺序做菜 (2*1 + 3*2 + 4*3 = 20)
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：satisfaction = [-1,-4,-5]
 * 输出：0
 * 解释：大家都不喜欢这些菜，所以不做任何菜就可以获得最大的 like-time 系数。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * n == satisfaction.length
 * 1 <= n <= 500
 * -1000 <= satisfaction[i] <= 1000
 * <p>
 * <p>
 * Related Topics 贪心 数组 动态规划 排序 👍 134 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int[][] dp = new int[2][satisfaction.length + 1];
        int max = 0;
        // 0 分数 1 前缀和
        for (int i = satisfaction.length - 1; i >= 0; i--) {
            dp[1][i] = satisfaction[i] + dp[1][i + 1];
            dp[0][i] = dp[1][i] + dp[0][i + 1];
            max = Math.max(max, dp[0][i]);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

