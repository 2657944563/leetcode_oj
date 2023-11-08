// 开始时间：2023-11-08 14:27:30
// 题目标题：最长平衡子字符串
// 题目标记：find-the-longest-balanced-substring-of-a-binary-string
// 题目编号：2609
// 题目描述：

/**
 * 给你一个仅由 0 和 1 组成的二进制字符串 s 。
 * <p>
 * 如果子字符串中 所有的 0 都在 1 之前 且其中 0 的数量等于 1 的数量，则认为 s 的这个子字符串是平衡子字符串。请注意，空子字符串也视作平衡子字符串
 * 。
 * <p>
 * 返回 s 中最长的平衡子字符串长度。
 * <p>
 * 子字符串是字符串中的一个连续字符序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "01000111"
 * 输出：6
 * 解释：最长的平衡子字符串是 "000111" ，长度为 6 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "00111"
 * 输出：4
 * 解释：最长的平衡子字符串是 "0011" ，长度为  4 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：s = "111"
 * 输出：0
 * 解释：除了空子字符串之外不存在其他平衡子字符串，所以答案为 0 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 50
 * '0' <= s[i] <= '1'
 * <p>
 * <p>
 * Related Topics 字符串 👍 57 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); ) {
            int i1 = 0, i2 = 0;
            while (i < s.length()) {
                if (s.charAt(i) == '0') {
                    i1++;
                } else {
                    break;
                }
                i++;
            }
            while (i < s.length()) {
                if (s.charAt(i) == '1') {
                    i2++;
                } else {
                    break;
                }
                i++;
            }
            sum = Math.max(sum, Math.min(i1, i2) * 2);
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

