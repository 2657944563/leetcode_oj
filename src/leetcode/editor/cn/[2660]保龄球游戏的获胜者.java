// 开始时间：2023-12-25 23:09:32
// 题目标题：保龄球游戏的获胜者
// 题目标记：determine-the-winner-of-a-bowling-game
// 题目编号：2660
// 题目描述：

/**
 * 给你两个下标从 0 开始的整数数组 player1 和 player2 ，分别表示玩家 1 和玩家 2 击中的瓶数。
 * <p>
 * 保龄球比赛由 n 轮组成，每轮的瓶数恰好为 10 。
 * <p>
 * 假设玩家在第 i 轮中击中 xi 个瓶子。玩家第 i 轮的价值为：
 * <p>
 * <p>
 * 如果玩家在该轮的前两轮的任何一轮中击中了 10 个瓶子，则为 2xi 。
 * 否则，为 xi 。
 * <p>
 * <p>
 * 玩家的得分是其 n 轮价值的总和。
 * <p>
 * 返回
 * <p>
 * <p>
 * 如果玩家 1 的得分高于玩家 2 的得分，则为 1 ；
 * 如果玩家 2 的得分高于玩家 1 的得分，则为 2 ；
 * 如果平局，则为 0 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：player1 = [4,10,7,9], player2 = [6,5,2,3]
 * 输出：1
 * 解释：player1 的得分是 4 + 10 + 2*7 + 2*9 = 46 。
 * player2 的得分是 6 + 5 + 2 + 3 = 16 。
 * player1 的得分高于 player2 的得分，所以 play1 在比赛中获胜，答案为 1 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：player1 = [3,5,7,6], player2 = [8,10,10,2]
 * 输出：2
 * 解释：player1 的得分是 3 + 5 + 7 + 6 = 21 。
 * player2 的得分是 8 + 10 + 2*10 + 2*2 = 42 。
 * player2 的得分高于 player1 的得分，所以 play2 在比赛中获胜，答案为 2 。
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：player1 = [2,3], player2 = [4,1]
 * 输出：0
 * 解释：player1 的得分是 2 + 3 = 5 。
 * player2 的得分是 4 + 1 = 5 。
 * player1 的得分等于 player2 的得分，所以这一场比赛平局，答案为 0 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * n == player1.length == player2.length
 * 1 <= n <= 1000
 * 0 <= player1[i], player2[i] <= 10
 * <p>
 * <p>
 * Related Topics 数组 模拟 👍 44 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int isWinner(int[] player1, int[] player2) {
        int i1 = 0, i2 = 0;
        for (int i = 0; i < player1.length; i++) {
            if (check(i, player1)) {
                i1 += player1[i] * 2;
            } else {
                i1 += player1[i];
            }
            if (check(i, player2)) {
                i2 += player2[i] * 2;
            } else {
                i2 += player2[i];
            }
        }
        if (i1 > i2) {
            return 1;
        } else if (i1 < i2) {
            return 2;
        } else {
            return 0;
        }
    }

    boolean check(int i, int[] player) {
        if (i > 0 && player[i - 1] == 10) {
            return true;
        }
        return i > 1 && player[i - 2] == 10;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

