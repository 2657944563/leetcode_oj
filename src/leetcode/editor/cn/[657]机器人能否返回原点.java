// 开始时间：2023-09-19 19:18:29
// 题目标题：机器人能否返回原点
// 题目标记：robot-return-to-origin
// 题目编号：657
// 题目描述：

/**
 * 在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，判断这个机器人在完成移动后是否在 (0, 0) 处结束。
 * <p>
 * 移动顺序由字符串 moves 表示。字符 move[i] 表示其第 i 次移动。机器人的有效动作有 R（右），L（左），U（上）和 D（下）。
 * <p>
 * 如果机器人在完成所有动作后返回原点，则返回 true。否则，返回 false。
 * <p>
 * 注意：机器人“面朝”的方向无关紧要。 “R” 将始终使机器人向右移动一次，“L” 将始终向左移动等。此外，假设每次移动机器人的移动幅度相同。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: moves = "UD"
 * 输出: true
 * 解释：机器人向上移动一次，然后向下移动一次。所有动作都具有相同的幅度，因此它最终回到它开始的原点。因此，我们返回 true。
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: moves = "LL"
 * 输出: false
 * 解释：机器人向左移动两次。它最终位于原点的左侧，距原点有两次 “移动” 的距离。我们返回 false，因为它在移动结束时没有返回原点。
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 1 <= moves.length <= 2 * 10⁴
 * moves 只包含字符 'U', 'D', 'L' 和 'R'
 * <p>
 * Related Topics 字符串 模拟 👍 253 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean judgeCircle(String moves) {
        if (moves.length() % 2 == 1) {
            return false;
        }
        int l = 0, w = 0;
        for (byte a : moves.getBytes()) {
            if (a == 'L') {
                l++;
            } else if (a == 'R') {
                l--;
            } else if (a == 'U') {
                w++;
            } else {
                w--;
            }
        }
        return Math.abs(l) + Math.abs(w) == 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

