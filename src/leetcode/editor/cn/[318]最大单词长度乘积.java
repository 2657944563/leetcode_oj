// 开始时间：2023-11-06 16:26:45
// 题目标题：最大单词长度乘积
// 题目标记：maximum-product-of-word-lengths
// 题目编号：318
// 题目描述：

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给你一个字符串数组 words ，找出并返回 length(words[i]) * length(words[j]) 的最大值，并且这两个单词不含有公共字母。如
 * 果不存在这样的两个单词，返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：words = ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出：16
 * 解释：这两个单词为 "abcw", "xtfn"。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：words = ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出：4
 * 解释：这两个单词为 "ab", "cd"。
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：words = ["a","aa","aaa","aaaa"]
 * 输出：0
 * 解释：不存在这样的两个单词。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 2 <= words.length <= 1000
 * 1 <= words[i].length <= 1000
 * words[i] 仅包含小写字母
 * <p>
 * <p>
 * Related Topics 位运算 数组 字符串 👍 477 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProduct(String[] words) {
        int sum = 0;
        Arrays.sort(words, Comparator.comparingInt(String::length));
        long[] array = new long[words.length];
        for (int i = words.length - 1; i > 0; i--) {
            if (array[i] == 0) {
                array[i] = clac(words[i]);
            }
            for (int l = i - 1; l >= 0; l--) {
                if (array[l] == 0) {
                    array[l] = clac(words[l]);
                }
                if ((array[i] & array[l]) == 0 &&
                        sum < words[i].length() * words[l].length()) {
                    sum = words[i].length() * words[l].length();
                }

            }
        }
        return sum;
    }

    long clac(String string) {
        long t = 0;
        for (char c : string.toCharArray()) {
            t |= 1L << (c - 'a' + 1);
        }
        return t;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

