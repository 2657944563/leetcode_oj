// 开始时间：2023-10-29 14:51:18
// 题目标题：解码字母到整数映射
// 题目标记：decrypt-string-from-alphabet-to-integer-mapping
// 题目编号：1309
// 题目描述：

/**
 * 给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：
 * <p>
 * <p>
 * 字符（'a' - 'i'）分别用（'1' - '9'）表示。
 * 字符（'j' - 'z'）分别用（'10#' - '26#'）表示。
 * <p>
 * <p>
 * 返回映射之后形成的新字符串。
 * <p>
 * 题目数据保证映射始终唯一。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "10#11#12"
 * 输出："jkab"
 * 解释："j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "1326#"
 * 输出："acz"
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 1000
 * s[i] 只包含数字（'0'-'9'）和 '#' 字符。
 * s 是映射始终存在的有效字符串。
 * <p>
 * <p>
 * Related Topics 字符串 👍 85 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            int l;
            if (s.charAt(i) == '#') {
                i--;
                l = s.charAt(i) - '0';
                i--;
                l += (s.charAt(i) - '0') * 10;
                sb.insert(0, (char) (l + 'a' - 1));
            } else {
                sb.insert(0, (char) (s.charAt(i) - '0' - 1 + 'a'));
            }
        }
        return sb.toString();
    }

}
//leetcode submit region end(Prohibit modification and deletion)

