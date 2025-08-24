// 开始时间：2025-08-23 19:45:53
// 题目标题：重新排列字符串
// 题目标记：shuffle-string
// 题目编号：1528
// 题目描述：

/**
 * 给你一个字符串 s 和一个 长度相同 的整数数组 indices 。
 * <p>
 * 请你重新排列字符串 s ，其中第 i 个字符需要移动到 indices[i] 指示的位置。
 * <p>
 * 返回重新排列后的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入：s = "codeleet", indices = [4,5,6,7,0,2,1,3]
 * 输出："leetcode"
 * 解释：如图所示，"codeleet" 重新排列后变为 "leetcode" 。
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "abc", indices = [0,1,2]
 * 输出："abc"
 * 解释：重新排列后，每个字符都还留在原来的位置上。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * s.length == indices.length == n
 * 1 <= n <= 100
 * s 仅包含小写英文字母
 * 0 <= indices[i] < n
 * indices 的所有的值都是 唯一 的
 * <p>
 * <p>
 * Related Topics 数组 字符串 👍 65 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String restoreString(String s, int[] indices) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            sb.setCharAt(indices[i], s.charAt(i));
        }
        return sb.toString();

    }
}
//leetcode submit region end(Prohibit modification and deletion)

