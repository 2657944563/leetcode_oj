// 开始时间：2023-10-10 22:39:33
// 题目标题：仅仅反转字母
// 题目标记：reverse-only-letters
// 题目编号：917
// 题目描述：

/**
 * 给你一个字符串 s ，根据下述规则反转字符串：
 * <p>
 * <p>
 * 所有非英文字母保留在原有位置。
 * 所有英文字母（小写或大写）位置反转。
 * <p>
 * <p>
 * 返回反转后的 s 。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "ab-cd"
 * 输出："dc-ba"
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "a-bC-dEf-ghIj"
 * 输出："j-Ih-gfE-dCba"
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：s = "Test1ng-Leet=code-Q!"
 * 输出："Qedo1ct-eeLg=ntse-T!"
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示
 * <p>
 * <p>
 * 1 <= s.length <= 100
 * s 仅由 ASCII 值在范围 [33, 122] 的字符组成
 * s 不含 '\"' 或 '\\'
 * <p>
 * <p>
 * Related Topics 双指针 字符串 👍 202 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseOnlyLetters(String s) {
        StringBuilder str = new StringBuilder();
        for (char c : s.toCharArray()) {
            if ((c <= 'Z' && c >= 'A') || (c <= 'z' && c >= 'a')) {
                str.append(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0, l = str.length(); i < s.length(); i++) {
            char c = s.charAt(i);
            if ((c <= 'Z' && c >= 'A') || (c <= 'z' && c >= 'a')) {
                sb.append(str.charAt(--l));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

