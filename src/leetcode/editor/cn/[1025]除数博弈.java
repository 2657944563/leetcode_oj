// 开始时间：2023-10-17 23:03:14
// 题目标题：除数博弈
// 题目标记：divisor-game
// 题目编号：1025
// 题目描述：

import java.util.Arrays;

/**
 * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
 * <p>
 * 最初，黑板上有一个数字 n 。在每个玩家的回合，玩家需要执行以下操作：
 * <p>
 * <p>
 * 选出任一 x，满足 0 < x < n 且 n % x == 0 。
 * 用 n - x 替换黑板上的数字 n 。
 * <p>
 * <p>
 * 如果玩家无法执行这些操作，就会输掉游戏。
 * <p>
 * 只有在爱丽丝在游戏中取得胜利时才返回 true 。假设两个玩家都以最佳状态参与游戏。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 2
 * 输出：true
 * 解释：爱丽丝选择 1，鲍勃无法进行操作。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 3
 * 输出：false
 * 解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= n <= 1000
 * <p>
 * <p>
 * Related Topics 脑筋急转弯 数学 动态规划 博弈 👍 417 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean divisorGame(int n) {
        return (n & 1) == 0;

//        boolean[] dp = new boolean[n + 1];
//        for (int i = 0; i <= n; i++) {
//            dp[i] = Dfs(dp, i);
//        }
//        //System.out.println(Arrays.toString(dp));
//        return dp[n];
    }

    boolean Dfs(boolean[] dp, int n) {
        if (n == 1 || n == 0) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        for (int i = n - 1; i > 1; i--) {
            if (dp[i] && n % i == 0) {
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

