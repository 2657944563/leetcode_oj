// 开始时间：2023-10-05 11:53:42
// 题目标题：最常见的单词
// 题目标记：most-common-word
// 题目编号：819
// 题目描述：

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个段落 (paragraph) 和一个禁用单词列表 (banned)。返回出现次数最多，同时不在禁用列表中的单词。
 * <p>
 * 题目保证至少有一个词不在禁用列表中，而且答案唯一。
 * <p>
 * 禁用列表中的单词用小写字母表示，不含标点符号。段落中的单词不区分大小写。答案都是小写字母。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * 输出: "ball"
 * 解释:
 * "hit" 出现了3次，但它是一个禁用的单词。
 * "ball" 出现了2次 (同时没有其他单词出现2次)，所以它是段落里出现次数最多的，且不在禁用列表中的单词。
 * 注意，所有这些单词在段落里不区分大小写，标点符号需要忽略（即使是紧挨着单词也忽略， 比如 "ball,"），
 * "hit"不是最终的答案，虽然它出现次数更多，但它在禁用单词列表中。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= 段落长度 <= 1000
 * 0 <= 禁用单词个数 <= 100
 * 1 <= 禁用单词长度 <= 10
 * 答案是唯一的, 且都是小写字母 (即使在 paragraph 里是大写的，即使是一些特定的名词，答案都是小写的。)
 * paragraph 只包含字母、空格和下列标点符号!?',;.
 * 不存在没有连字符或者带有连字符的单词。
 * 单词里只包含字母，不会出现省略号或者其他标点符号。
 * <p>
 * <p>
 * Related Topics 哈希表 字符串 计数 👍 227 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        HashMap<String, Integer> hm = new HashMap<>();
        int l = 0, r = 0;
        A:
        while (l < paragraph.length() && r < paragraph.length()) {
            if (paragraph.charAt(l) >= 'a' && paragraph.charAt(l) <= 'z') {
                r = l;
                while (r < paragraph.length() && paragraph.charAt(r) >= 'a' && paragraph.charAt(r) <= 'z') {
                    r++;
                }
                String substring = paragraph.substring(l, r);
                for (String target : banned) {
                    if (target.equals(substring)) {
                        l = r + 1;
                        continue A;
                    }
                }
                hm.merge(substring, 1, Integer::sum);
                l = r + 1;
            } else {
                l++;
            }
        }
        //  System.out.println(hm.entrySet().toString());
        return hm.entrySet().stream().max(Comparator.comparingInt(Map.Entry::getValue)).get().getKey();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

