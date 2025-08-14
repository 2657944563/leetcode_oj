// 开始时间：2025-08-10 16:59:44
// 题目标题：单词拆分 II
// 题目标记：word-break-ii
// 题目编号：140
// 题目描述：

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s 和一个字符串字典
 * wordDict ，在字符串
 * s 中增加空格来构建一个句子，使得句子中所有的单词都在词典中。以任意顺序 返回所有这些可能的句子。
 * <p>
 * 注意：词典中的同一个单词可能在分段中被重复使用多次。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入:s = "catsanddog", wordDict = ["cat","cats","and","sand","dog"]
 * 输出:["cats and dog","cat sand dog"]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入:s = "pineapplepenapple", wordDict = ["apple","pen","applepen","pine",
 * "pineapple"]
 * 输出:["pine apple pen apple","pineapple pen apple","pine applepen apple"]
 * 解释: 注意你可以重复使用字典中的单词。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入:s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * 输出:[]
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 1 <= s.length <= 20
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 10
 * s 和 wordDict[i] 仅有小写英文字母组成
 * wordDict 中所有字符串都 不同
 * <p>
 * <p>
 * Related Topics 字典树 记忆化搜索 数组 哈希表 字符串 动态规划 回溯 👍 794 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> ans = new ArrayList<>();
    List<String> wordList = new ArrayList<>();
    Set<String> dictionary = new HashSet<>(); // 字典
    int n; // 字符串长度

    public List<String> wordBreak(String s, List<String> wordDict) {
        n = s.length();
        dictionary.addAll(wordDict);
        backtrack(s, 0);
        return ans;
    }

    public void backtrack(String s, int start) {
        if (start == n) {
            ans.add(String.join(" ", wordList));
            return;
        }

        for (int i = start; i < n; i++) {
            String sub = s.substring(start, i + 1);
            if (dictionary.contains(sub)) {
                wordList.add(sub);
                backtrack(s, i + 1);
                wordList.remove(wordList.size() - 1);
            }
        }
    }
}

//leetcode submit region end(Prohibit modification and deletion)

