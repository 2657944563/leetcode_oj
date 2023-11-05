// 开始时间：2023-11-05 19:20:55
// 题目标题：重复的DNA序列
// 题目标记：repeated-dna-sequences
// 题目编号：187
// 题目描述：

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * DNA序列 由一系列核苷酸组成，缩写为
 * 'A', 'C', 'G' 和
 * 'T'.。
 * <p>
 * <p>
 * 例如，
 * "ACGAATTCCG" 是一个 DNA序列 。
 * <p>
 * <p>
 * 在研究 DNA 时，识别 DNA 中的重复序列非常有用。
 * <p>
 * 给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC","CCCCCAAAAA"]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "AAAAAAAAAAAAA"
 * 输出：["AAAAAAAAAA"]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 0 <= s.length <= 10⁵
 * s[i]=='A'、'C'、'G' or 'T'
 * <p>
 * <p>
 * Related Topics 位运算 哈希表 字符串 滑动窗口 哈希函数 滚动哈希 👍 544 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> hm = new HashMap<>();
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < s.length() - 9; i++) {
            String str = s.substring(i, i + 10);
            Integer u = hm.get(str);
            if (u != null) {
                hm.put(str, u + 1);
                if (u == 1) {
                    list.add(str);
                }
            } else {
                hm.put(str, 1);
            }

        }
        return list;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

