// 开始时间：2023-10-14 20:11:51
// 题目标题：删除最外层的括号
// 题目标记：remove-outermost-parentheses
// 题目编号：1021
// 题目描述：

import java.util.LinkedList;

/**
 * 有效括号字符串为空 ""、"(" + A + ")" 或 A + B ，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。
 * <p>
 * <p>
 * 例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 * <p>
 * <p>
 * 如果有效字符串 s 非空，且不存在将其拆分为 s = A + B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
 * <p>
 * 给出一个非空有效字符串 s，考虑将其进行原语化分解，使得：s = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 * <p>
 * 对 s 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 s 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "(()())(())"
 * 输出："()()()"
 * 解释：
 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "(()())(())(()(()))"
 * 输出："()()()()(())"
 * 解释：
 * 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：s = "()()"
 * 输出：""
 * 解释：
 * 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
 * 删除每个部分中的最外层括号后得到 "" + "" = ""。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 10⁵
 * s[i] 为 '(' 或 ')'
 * s 是一个有效括号字符串
 * <p>
 * <p>
 * Related Topics 栈 字符串 👍 297 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String removeOuterParentheses(String s) {
        LinkedList<Character> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int l1 = 0, l2 = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            l1 += c == '(' ? 1 : 0;
            l2 += c == ')' ? 1 : 0;
            // i % 1 == 1
            if (l1 == l2) {
                list.removeFirst();
                while (!list.isEmpty()) {
                    sb.append(list.removeFirst());
                }
                l1 = 0;
                l2 = 0;
            } else {
                list.add(c);
            }
        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

