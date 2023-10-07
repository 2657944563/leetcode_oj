// 开始时间：2023-10-07 11:51:22
// 题目标题：亲密字符串
// 题目标记：buddy-strings
// 题目编号：859
// 题目描述：

import java.util.HashSet;

/**
 * 给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回 true ；否则返回 false 。
 * <p>
 * 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。
 * <p>
 * <p>
 * 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：s = "ab", goal = "ba"
 * 输出：true
 * 解释：你可以交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 相等。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：s = "ab", goal = "ab"
 * 输出：false
 * 解释：你只能交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 不相等。
 * <p>
 * 示例 3：
 * <p>
 * <p>
 * 输入：s = "aa", goal = "aa"
 * 输出：true
 * 解释：你可以交换 s[0] = 'a' 和 s[1] = 'a' 生成 "aa"，此时 s 和 goal 相等。
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * <p>
 * 1 <= s.length, goal.length <= 2 * 10⁴
 * s 和 goal 由小写英文字母组成
 * <p>
 * <p>
 * Related Topics 哈希表 字符串 👍 296 👎 0
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean buddyStrings(String s, String goal) {
        HashSet<Character> hs = new HashSet<>();
        boolean flag = false;
        if (s.length() != goal.length()) {
            return false;
        }
        int i1 = -1, i2 = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (i1 == -1) {
                    i1 = i;
                } else if (i2 == -1) {
                    i2 = i;
                } else {
                    return false;
                }
            } else if (!flag) {
                flag = !hs.add(s.charAt(i));
            }
        }
        if (i1 != i2 && i2 == -1) {
            return false;
        } else if (i1 == i2 && i1 == -1) {
            return flag;
        }
        if (s.charAt(i1) != goal.charAt(i2) || s.charAt(i2) != goal.charAt(i1)) {
            return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

