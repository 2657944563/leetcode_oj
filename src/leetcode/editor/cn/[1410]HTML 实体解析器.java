// 开始时间：2023-11-23 12:59:17
// 题目标题：HTML 实体解析器
// 题目标记：html-entity-parser
// 题目编号：1410
// 题目描述：

import java.util.HashMap;

/**
 * 「HTML 实体解析器」 是一种特殊的解析器，它将 HTML 代码作为输入，并用字符本身替换掉所有这些特殊的字符实体。
 * <p>
 * HTML 里这些特殊字符和它们对应的字符实体包括：
 * <p>
 * <p>
 * 双引号：字符实体为 &quot; ，对应的字符是 " 。
 * 单引号：字符实体为 &apos; ，对应的字符是 ' 。
 * 与符号：字符实体为 &amp; ，对应对的字符是 & 。
 * 大于号：字符实体为 &gt; ，对应的字符是 > 。
 * 小于号：字符实体为 &lt; ，对应的字符是 < 。
 * 斜线号：字符实体为 &frasl; ，对应的字符是 / 。
 * <p>
 * <p>
 * 给你输入字符串 text ，请你实现一个 HTML 实体解析器，返回解析器解析后的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：text = "&amp; is an HTML entity but &ambassador; is not."
 * 输出："& is an HTML entity but &ambassador; is not."
 * 解释：解析器把字符实体 &amp; 用 & 替换
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：text = "and I quote: &quot;...&quot;"
 * 输出："and I quote: \"...\""
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：text = "Stay home! Practice on Leetcode :)"
 * 输出："Stay home! Practice on Leetcode :)"
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * <p>
 * 输入：text = "x &gt; y &amp;&amp; x &lt; y is always false"
 * 输出："x > y && x < y is always false"
 * <p>
 * <p>
 * 示例 5：
 * <p>
 * <p>
 * 输入：text = "leetcode.com&frasl;problemset&frasl;all"
 * 输出："leetcode.com/problemset/all"
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= text.length <= 10^5
 * 字符串可能包含 256 个ASCII 字符中的任意字符。
 * <p>
 * <p>
 * Related Topics 哈希表 字符串 👍 51 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String entityParser(String text) {
        HashMap<String, String> hm = new HashMap<>();
        hm.put("&quot;", "\"");
        hm.put("&apos;", "'");
        hm.put("&amp;", "&");
        hm.put("&gt;", ">");
        hm.put("&lt;", "<");
        hm.put("&frasl;", "/");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '&') {
                String str;
                if (i + 6 < text.length()) {
                    str = text.substring(i, i + 7);
                    if (hm.containsKey(str)) {
                        sb.append(hm.get(str));
                        i += 6;
                        continue;
                    }
                }
                if (i + 5 < text.length()) {
                    str = text.substring(i, i + 6);
                    if (hm.containsKey(str)) {
                        sb.append(hm.get(str));
                        i += 5;
                        continue;
                    }
                }
                if (i + 4 < text.length()) {
                    str = text.substring(i, i + 5);
                    if (hm.containsKey(str)) {
                        sb.append(hm.get(str));
                        i += 4;
                        continue;
                    }
                }
                if (i + 3 < text.length()) {
                    str = text.substring(i, i + 4);
                    if (hm.containsKey(str)) {
                        sb.append(hm.get(str));
                        i += 3;
                        continue;
                    }
                }
            }
            sb.append(text.charAt(i));
            System.out.println(text.charAt(i));

        }
        return sb.toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

