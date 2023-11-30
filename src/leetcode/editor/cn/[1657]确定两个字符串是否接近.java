// 开始时间：2023-11-30 15:33:02
// 题目标题：确定两个字符串是否接近
// 题目标记：determine-if-two-strings-are-close
// 题目编号：1657
// 题目描述：

import java.util.HashMap;
import java.util.Map;

/**
 * 如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 接近 ：
 * <p>
 * <p>
 * 操作 1：交换任意两个 现有 字符。
 * <p>
 * <p>
 * <p>
 * 例如，abcde -> aecdb
 * <p>
 * <p>
 * 操作 2：将一个 现有 字符的每次出现转换为另一个 现有 字符，并对另一个字符执行相同的操作。
 * <p>
 * 例如，aacabb -> bbcbaa（所有 a 转化为 b ，而所有的 b 转换为 a ）
 * <p>
 * <p>
 * <p>
 * <p>
 * 你可以根据需要对任意一个字符串多次使用这两种操作。
 * <p>
 * 给你两个字符串，word1 和 word2 。如果 word1 和 word2 接近 ，就返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：word1 = "abc", word2 = "bca"
 * 输出：true
 * 解释：2 次操作从 word1 获得 word2 。
 * 执行操作 1："abc" -> "acb"
 * 执行操作 1："acb" -> "bca"
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：word1 = "a", word2 = "aa"
 * 输出：false
 * 解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：word1 = "cabbba", word2 = "abbccc"
 * 输出：true
 * 解释：3 次操作从 word1 获得 word2 。
 * 执行操作 1："cabbba" -> "caabbb"
 * 执行操作 2："caabbb" -> "baaccc"
 * 执行操作 2："baaccc" -> "abbccc"
 * <p>
 * <p>
 * 示例 4：
 * <p>
 * <p>
 * 输入：word1 = "cabbba", word2 = "aabbss"
 * 输出：false
 * 解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= word1.length, word2.length <= 10⁵
 * word1 和 word2 仅包含小写英文字母
 * <p>
 * <p>
 * Related Topics 哈希表 字符串 排序 👍 112 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        HashMap<Character, Integer> hm1 = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();
        for (char c : word1.toCharArray()) {
            hm1.merge(c, 1, Integer::sum);
        }
        for (char c : word2.toCharArray()) {
            hm2.merge(c, 1, Integer::sum);
        }

        if (!hm1.keySet().equals(hm2.keySet())) return false;

        HashMap<Integer, Integer> hm3 = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : hm1.entrySet()) {
            hm3.merge(entry.getValue(), 1, Integer::sum);
        }
        for (Map.Entry<Character, Integer> entry : hm2.entrySet()) {
            Integer en = hm3.get(entry.getValue());
            if (en != null && en > 0) {
                if (en == 1) {
                    hm3.remove(entry.getValue());
                    continue;
                }
                hm3.put(entry.getValue(), hm3.get(entry.getValue()) - 1);
            }
        }


        return hm3.isEmpty();

    }
}
//leetcode submit region end(Prohibit modification and deletion)

