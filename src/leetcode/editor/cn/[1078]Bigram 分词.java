// 开始时间：2023-10-19 10:59:31
// 题目标题：Bigram 分词
// 题目标记：occurrences-after-bigram
// 题目编号：1078
// 题目描述：

import java.util.LinkedList;

/**
 * 给出第一个词 first 和第二个词 second，考虑在某些文本 text 中可能以 "first second third" 形式出现的情况，其中
 * second 紧随 first 出现，third 紧随 second 出现。
 * <p>
 * 对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：text = "alice is a good girl she is a good student", first = "a", second =
 * "good"
 * 输出：["girl","student"]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：text = "we will we will rock you", first = "we", second = "will"
 * 输出：["we","rock"]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= text.length <= 1000
 * text 由小写英文字母和空格组成
 * text 中的所有单词之间都由 单个空格字符 分隔
 * 1 <= first.length, second.length <= 10
 * first 和 second 由小写英文字母组成
 * <p>
 * <p>
 * Related Topics 字符串 👍 78 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        String[] s = text.split(" ");
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < s.length - 2; i++) {
            if (s[i].equals(first) && s[i + 1].equals(second)) {
                list.add(s[i + 2]);
            }
        }
        return list.toArray(new String[0]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

