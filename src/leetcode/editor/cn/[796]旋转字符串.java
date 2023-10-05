// 开始时间：2023-10-04 20:26:24
// 题目标题：旋转字符串
// 题目标记：rotate-string
// 题目编号：796
// 题目描述：

/**
 * 给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。
 * <p>
 * s 的 旋转操作 就是将 s 最左边的字符移动到最右边。
 * <p>
 * <p>
 * 例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: s = "abcde", goal = "cdeab"
 * 输出: true
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: s = "abcde", goal = "abced"
 * 输出: false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * <p>
 * 1 <= s.length, goal.length <= 100
 * s 和 goal 由小写英文字母组成
 * <p>
 * <p>
 * Related Topics 字符串 字符串匹配 👍 299 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean rotateString(String s, String goal) {
        StringBuilder s1 = new StringBuilder(s);
        StringBuilder s2 = new StringBuilder(goal);
        for (int i = 0; i < s1.length(); i++) {
            if (s1.compareTo(s2) == 0) {
                return true;
            }
            s1.append(s1.charAt(0));
            s1.delete(0, 1);
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

