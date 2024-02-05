// 开始时间：2024-02-05 16:56:02
// 题目标题：检查两个字符串数组是否相等
// 题目标记：check-if-two-string-arrays-are-equivalent
// 题目编号：1662
// 题目描述：

/**
 * 给你两个字符串数组 word1 和 word2 。如果两个数组表示的字符串相同，返回 true ；否则，返回 false 。
 * <p>
 * 数组表示的字符串 是由数组中的所有元素 按顺序 连接形成的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：word1 = ["ab", "c"], word2 = ["a", "bc"]
 * 输出：true
 * 解释：
 * word1 表示的字符串为 "ab" + "c" -> "abc"
 * word2 表示的字符串为 "a" + "bc" -> "abc"
 * 两个字符串相同，返回 true
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：word1 = ["a", "cb"], word2 = ["ab", "c"]
 * 输出：false
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
 * 输出：true
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= word1.length, word2.length <= 10³
 * 1 <= word1[i].length, word2[i].length <= 10³
 * 1 <= sum(word1[i].length), sum(word2[i].length) <= 10³
 * word1[i] 和 word2[i] 由小写字母组成
 * <p>
 * <p>
 * Related Topics 数组 字符串 👍 97 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (String s : word1) {
            sb1.append(s);
        }
        for (String s : word2) {
            sb2.append(s);
        }
        return sb1.toString().equals(sb2.toString());

    }
}
//leetcode submit region end(Prohibit modification and deletion)

