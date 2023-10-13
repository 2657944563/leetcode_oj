// 开始时间：2023-10-13 21:41:01
// 题目标题：增减字符串匹配
// 题目标记：di-string-match
// 题目编号：942
// 题目描述：

/**
 * 由范围 [0,n] 内所有整数组成的 n + 1 个整数的排列序列可以表示为长度为 n 的字符串 s ，其中:
 * <p>
 * <p>
 * 如果 perm[i] < perm[i + 1] ，那么 s[i] == 'I'
 * 如果 perm[i] > perm[i + 1] ，那么 s[i] == 'D'
 * <p>
 * <p>
 * 给定一个字符串 s ，重构排列 perm 并返回它。如果有多个有效排列perm，则返回其中 任何一个 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "IDID"
 * 输出：[0,4,1,3,2]
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "III"
 * 输出：[0,1,2,3]
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：s = "DDI"
 * 输出：[3,2,0,1]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 10⁵
 * s 只包含字符 "I" 或 "D"
 * <p>
 * <p>
 * Related Topics 贪心 数组 双指针 字符串 👍 459 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] diStringMatch(String s) {
        int[] result = new int[s.length() + 1];
        int i = 0, l = s.length();
        for (int n = 0; n < s.length(); n++) {
            if (s.charAt(n) == 'I') {
                result[n] = i++;
            } else {
                result[n] = l--;
            }
        }
        result[s.length()] = i;
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

