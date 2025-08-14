// 开始时间：2025-08-10 14:00:46
// 题目标题：单词拆分
// 题目标记：word-break
// 题目编号：139
// 题目描述：

import java.util.List;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 * <p>
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
 *      注意，你可以重复使用字典中的单词。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 300
 * 1 <= wordDict.length <= 1000
 * 1 <= wordDict[i].length <= 20
 * s 和 wordDict[i] 仅由小写英文字母组成
 * wordDict 中的所有字符串 互不相同
 * <p>
 * <p>
 * Related Topics 字典树 记忆化搜索 数组 哈希表 字符串 动态规划 👍 2803 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[] dp = new int[s.length()];
        StringBuilder subStr = new StringBuilder(s);
        for (int i = subStr.length() - 1; i >= 0; i--) {
            for (String key : wordDict) {
                if (key.length() <= s.length() - i
                        && subStr.substring(i, i + key.length()).equals(key)) {
                    if (i + key.length() >= s.length()) {
                        dp[i] = 1;
                    } else if (dp[i + key.length()] != 0) {
                        dp[i] = 1;
                    }
                }
            }

        }
        return dp[0] == 1;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

