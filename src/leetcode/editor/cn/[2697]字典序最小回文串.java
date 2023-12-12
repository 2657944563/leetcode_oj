// 开始时间：2023-12-13 00:48:16
// 题目标题：字典序最小回文串
// 题目标记：lexicographically-smallest-palindrome
// 题目编号：2697
// 题目描述：

/**
 * 给你一个由 小写英文字母 组成的字符串 s ，你可以对其执行一些操作。在一步操作中，你可以用其他小写英文字母 替换 s 中的一个字符。
 * <p>
 * 请你执行 尽可能少的操作 ，使 s 变成一个 回文串 。如果执行 最少 操作次数的方案不止一种，则只需选取 字典序最小 的方案。
 * <p>
 * 对于两个长度相同的字符串 a 和 b ，在 a 和 b 出现不同的第一个位置，如果该位置上 a 中对应字母比 b 中对应字母在字母表中出现顺序更早，则认为
 * a 的字典序比 b 的字典序要小。
 * <p>
 * 返回最终的回文字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "egcfe"
 * 输出："efcfe"
 * 解释：将 "egcfe" 变成回文字符串的最小操作次数为 1 ，修改 1 次得到的字典序最小回文字符串是 "efcfe"，只需将 'g' 改为 'f' 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "abcd"
 * 输出："abba"
 * 解释：将 "abcd" 变成回文字符串的最小操作次数为 2 ，修改 2 次得到的字典序最小回文字符串是 "abba" 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：s = "seven"
 * 输出："neven"
 * 解释：将 "seven" 变成回文字符串的最小操作次数为 1 ，修改 1 次得到的字典序最小回文字符串是 "neven" 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 1000
 * s 仅由小写英文字母组成
 * <p>
 * <p>
 * Related Topics 贪心 双指针 字符串 👍 15 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String makeSmallestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                if (s.charAt(l) < s.charAt(r)) {
                    sb.replace(r, r + 1, s.substring(l, l + 1));
                } else {
                    sb.replace(l, l + 1, s.substring(r, r + 1));

                }
            }
            l++;
            r--;
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

