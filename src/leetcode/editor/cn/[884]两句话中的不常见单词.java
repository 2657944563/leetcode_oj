// 开始时间：2023-10-07 15:35:46
// 题目标题：两句话中的不常见单词
// 题目标记：uncommon-words-from-two-sentences
// 题目编号：884
// 题目描述：

import java.util.HashSet;

/**
 * 句子 是一串由空格分隔的单词。每个 单词 仅由小写字母组成。
 * <p>
 * 如果某个单词在其中一个句子中恰好出现一次，在另一个句子中却 没有出现 ，那么这个单词就是 不常见的 。
 * <p>
 * 给你两个 句子 s1 和 s2 ，返回所有 不常用单词 的列表。返回列表中单词可以按 任意顺序 组织。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s1 = "this apple is sweet", s2 = "this apple is sour"
 * 输出：["sweet","sour"]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s1 = "apple apple", s2 = "banana"
 * 输出：["banana"]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s1.length, s2.length <= 200
 * s1 和 s2 由小写英文字母和空格组成
 * s1 和 s2 都不含前导或尾随空格
 * s1 和 s2 中的所有单词间均由单个空格分隔
 * <p>
 * <p>
 * Related Topics 哈希表 字符串 👍 191 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        HashSet<String> s1Set = new HashSet<>();
        HashSet<String> s2Set = new HashSet<>();
        for (String s : s1.split(" ")) {
            if (s1Set.contains(s)) {
                s2Set.add(s);
                s1Set.remove(s);
            } else if (!s2Set.contains(s)) {
                s1Set.add(s);
            }
        }
        for (String s : s2.split(" ")) {
            if (s1Set.contains(s)) {
                s2Set.add(s);
                s1Set.remove(s);
            } else if (!s2Set.contains(s)) {
                s1Set.add(s);
            }
        }
        return s1Set.toArray(String[]::new);
    }

}
//leetcode submit region end(Prohibit modification and deletion)

