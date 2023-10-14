// 开始时间：2023-10-14 11:51:44
// 题目标题：查找共用字符
// 题目标记：find-common-characters
// 题目编号：1002
// 题目描述：

import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个字符串数组 words ，请你找出所有在 words 的每个字符串中都出现的共用字符（ 包括重复字符），并以数组形式返回。你可以按 任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：words = ["bella","label","roller"]
 * 输出：["e","l","l"]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：words = ["cool","lock","cook"]
 * 输出：["c","o"]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 100
 * words[i] 由小写英文字母组成
 * <p>
 * <p>
 * Related Topics 数组 哈希表 字符串 👍 351 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> commonChars(String[] words) {
        if (words.length == 1) {
            return List.of(words[0].split(""));
        }
        LinkedList<String> list1 = new LinkedList<>();
        LinkedList<String> list2 = new LinkedList<>();
        for (int i = 0; i < words[0].length(); i++) {
            list1.add(String.valueOf(words[0].charAt(i)));
        }
        for (int l = 1; l < words.length; l++) {
            for (int i = 0; i < words[l].length(); i++) {
                String s = String.valueOf(words[l].charAt(i));
                if (list1.remove(s)) {
                    list2.add(s);
                }
            }
            list1.clear();
            list1.addAll(list2);
            list2.clear();
        }
        return list1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

