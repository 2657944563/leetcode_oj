// 开始时间：2023-10-05 11:53:43
// 题目标题：山羊拉丁文
// 题目标记：goat-latin
// 题目编号：824
// 题目描述：

/**
 * 给你一个由若干单词组成的句子 sentence ，单词间由空格分隔。每个单词仅由大写和小写英文字母组成。
 * <p>
 * 请你将句子转换为 “山羊拉丁文（Goat Latin）”（一种类似于 猪拉丁文 - Pig Latin 的虚构语言）。山羊拉丁文的规则如下：
 * <p>
 * <p>
 * 如果单词以元音开头（'a', 'e', 'i', 'o', 'u'），在单词后添加"ma"。
 * <p>
 * <p>
 * <p>
 * 例如，单词 "apple" 变为 "applema" 。
 * <p>
 * <p>
 * 如果单词以辅音字母开头（即，非元音字母），移除第一个字符并将它放到末尾，之后再添加"ma"。
 * <p>
 * 例如，单词 "goat" 变为 "oatgma" 。
 * <p>
 * <p>
 * 根据单词在句子中的索引，在单词最后添加与索引相同数量的字母'a'，索引从 1 开始。
 * <p>
 * 例如，在第一个单词后添加 "a" ，在第二个单词后添加 "aa" ，以此类推。
 * <p>
 * <p>
 * <p>
 * <p>
 * 返回将 sentence 转换为山羊拉丁文后的句子。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：sentence = "I speak Goat Latin"
 * 输出："Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：sentence = "The quick brown fox jumped over the lazy dog"
 * 输出："heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa
 * hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= sentence.length <= 150
 * sentence 由英文字母和空格组成
 * sentence 不含前导或尾随空格
 * sentence 中的所有单词由单个空格分隔
 * <p>
 * <p>
 * Related Topics 字符串 👍 133 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String toGoatLatin(String sentence) {
        StringBuilder sb = new StringBuilder();
        String flag = "aeiouAEIOU";
        String[] split = sentence.split(" ");
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            if (flag.indexOf(s.charAt(0)) == -1) {
                sb.append(s.substring(1));
                sb.append(s.charAt(0));
            } else {
                sb.append(s);
            }
            sb.append("ma");
            sb.append("a".repeat(i + 1));
            sb.append(' ');
        }
        return sb.substring(0, sb.length() - 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

