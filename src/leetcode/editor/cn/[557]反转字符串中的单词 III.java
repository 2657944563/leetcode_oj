// 开始时间：2023-09-23 18:46:06
// 题目标题：反转字符串中的单词 III
// 题目标记：reverse-words-in-a-string-iii
// 题目编号：557
// 题目描述：

/**
 * 给定一个字符串
 * s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 * <p>
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入： s = "God Ding"
 * 输出："doG gniD"
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 5 * 10⁴
 * <p>
 * s 包含可打印的 ASCII 字符。
 * <p>
 * s 不包含任何开头或结尾空格。
 * <p>
 * s 里 至少 有一个词。
 * <p>
 * s 中的所有单词都用一个空格隔开。
 * <p>
 * <p>
 * Related Topics 双指针 字符串 👍 563 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for (String s1 : s.split(" ")) {
            sb.append(new StringBuilder(s1).reverse()).append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

