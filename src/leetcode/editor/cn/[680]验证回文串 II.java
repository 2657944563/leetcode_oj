// 开始时间：2023-09-29 13:10:29
// 题目标题：验证回文串 II
// 题目标记：valid-palindrome-ii
// 题目编号：680
// 题目描述：

/**
 * 给你一个字符串 s，最多 可以从中删除一个字符。
 * <p>
 * 请你判断 s 是否能成为回文字符串：如果能，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "aba"
 * 输出：true
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "abca"
 * 输出：true
 * 解释：你可以删除字符 'c' 。
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：s = "abc"
 * 输出：false
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length <= 10⁵
 * s 由小写英文字母组成
 * <p>
 * <p>
 * Related Topics 贪心 双指针 字符串 👍 614 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean validPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                //分两种情况，一是右边减一，二是左边加一
                return isPalindrome(s, i, j - 1) || isPalindrome(s, i + 1, j);
            }
        }
        return true;
    }

    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

