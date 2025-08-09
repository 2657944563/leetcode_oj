// 开始时间：2025-08-09 18:04:15
// 题目标题：转换字符串的最少操作次数
// 题目标记：minimum-moves-to-convert-string
// 题目编号：2027
// 题目描述：

/**
 * 给你一个字符串 s ，由 n 个字符组成，每个字符不是 'X' 就是 'O' 。
 * <p>
 * 一次 操作 定义为从 s 中选出 三个连续字符 并将选中的每个字符都转换为 'O' 。注意，如果字符已经是 'O' ，只需要保持 不变 。
 * <p>
 * 返回将 s 中所有字符均转换为 'O' 需要执行的 最少 操作次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "XXX"
 * 输出：1
 * 解释：XXX -> OOO
 * 一次操作，选中全部 3 个字符，并将它们转换为 'O' 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "XXOX"
 * 输出：2
 * 解释：XXOX -> OOOX -> OOOO
 * 第一次操作，选择前 3 个字符，并将这些字符转换为 'O' 。
 * 然后，选中后 3 个字符，并执行转换。最终得到的字符串全由字符 'O' 组成。
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：s = "OOOO"
 * 输出：0
 * 解释：s 中不存在需要转换的 'X' 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 3 <= s.length <= 1000
 * s[i] 为 'X' 或 'O'
 * <p>
 * <p>
 * Related Topics 贪心 字符串 👍 71 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumMoves(String s) {
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'X') {
                l++;
                i += 2;
            }
        }
        return l;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

