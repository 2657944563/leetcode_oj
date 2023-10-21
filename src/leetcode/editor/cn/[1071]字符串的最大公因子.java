// 开始时间：2023-10-19 10:59:31
// 题目标题：字符串的最大公因子
// 题目标记：greatest-common-divisor-of-strings
// 题目编号：1071
// 题目描述：

import java.util.Arrays;

/**
 * 对于字符串 s 和 t，只有在 s = t + ... + t（t 自身连接 1 次或多次）时，我们才认定 “t 能除尽 s”。
 * <p>
 * 给定两个字符串 str1 和 str2 。返回 最长字符串 x，要求满足 x 能除尽 str1 且 x 能除尽 str2 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：str1 = "ABCABC", str2 = "ABC"
 * 输出："ABC"
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：str1 = "ABABAB", str2 = "ABAB"
 * 输出："AB"
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：str1 = "LEET", str2 = "CODE"
 * 输出：""
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= str1.length, str2.length <= 1000
 * str1 和 str2 由大写英文字母组成
 * <p>
 * <p>
 * Related Topics 数学 字符串 👍 363 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!str1.contains(str2) && !str2.contains(str1)) {
            return "";
        }
        String str3 = str1.length() < str2.length() ? str1 : str2;
        for (int i = str3.length(); i >= 1; i--) {
            String substring = str3.substring(0, i);
            if (str2.split(substring).length == 0 && str1.split(substring).length == 0) {
                return substring;
            }
        }
        return "";
    }
}
//leetcode submit region end(Prohibit modification and deletion)

