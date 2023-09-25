// 开始时间：2023-09-25 12:52:26
// 题目标题：字母异位词分组
// 题目标记：group-anagrams
// 题目编号：49
// 题目描述：

import java.util.*;

/**
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * <p>
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * <p>
 * 示例 2:
 * <p>
 * <p>
 * 输入: strs = [""]
 * 输出: [[""]]
 * <p>
 * <p>
 * 示例 3:
 * <p>
 * <p>
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= strs.length <= 10⁴
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 * <p>
 * <p>
 * Related Topics 数组 哈希表 字符串 排序 👍 1642 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, LinkedList<String>> result = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = String.valueOf(chars);
            if (result.containsKey(s)) {
                result.get(s).add(str);
            } else {
                final LinkedList<String> strings = new LinkedList<>();
                strings.add(str);
                result.put(s, strings);
            }
        }
        return new ArrayList<>(result.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)

